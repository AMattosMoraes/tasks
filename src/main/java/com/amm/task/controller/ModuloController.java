package com.amm.task.controller;

import com.amm.task.dto.ModuloDTO;
import com.amm.task.dto.SistemaDTO;
import com.amm.task.entities.Modulo;
import com.amm.task.mapper.ModuloMapper;
import com.amm.task.mapper.SistemaMapper;
import com.amm.task.services.ModuloService;
import com.amm.task.services.SistemaService;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ModuloController {

    @Autowired
    private ModuloService service;

    @Autowired
    private ModuloMapper mapper;

    @Autowired
    private SistemaService sistemaService;

    @Autowired
    private SistemaMapper sistemaMapper;

    @GetMapping("/cadastromodulo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("sistema", sistemaService.listarTodos());
        model.addAttribute("modulo", new ModuloDTO());
        return "cadastromodulo";
    }

    @GetMapping("/listamodulo")
    public String listarModulos(
            Model model,
            @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<ModuloDTO> moduloPage = service.findAll(pageable);

        model.addAttribute("listamodulo", moduloPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moduloPage.getTotalPages());
        model.addAttribute("totalElements",moduloPage.getTotalElements());

        return "listamodulo";
    }

    @PostMapping("/salvarmodulo")
    public String salvarModulo(@ModelAttribute("modulo") ModuloDTO dto) {
        service.insert(dto);
        return "redirect:/listamodulo";
    }

    @GetMapping("/editarmodulo/{id}")
    public String editarModulo(Model model, @PathVariable("id") Long id, RedirectAttributes attributes) {
        try{
            ModuloDTO dto = service.findById(id);
            model.addAttribute("modulo", dto);
            return "editarmodulo";
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "mensagemErro:",
                    "Não foi possivel editar: O Modulo com ID " + id + "não existe");
            return "editarmodulo";
        }
    }

    @PostMapping("/atualizarmodulo/{id}")
    public String atualizarModulo(@PathVariable("id") Long id, @ModelAttribute ModuloDTO dto, RedirectAttributes attributes) {
        try {
            dto.setId(id);
            service.update(id, dto);
            attributes.addFlashAttribute(
                    "mensagemSucesso",
                    "Modulo Atualizado com sucesso");
            return "redirect:/listamodulo";
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "mensagemErro",
                    "Erro ao atualizar: O modulo não foi encontrado no banco de dados.");
            return "redirect:/listamodulo";
        } catch (Exception e) {
            attributes.addFlashAttribute(
                    "mensagemErro",
                    "Erro inesperado ao salvar as alterações.");
            return "redirect:/listamodulo";
        }
    }

    @GetMapping("/excluirmodulo/{id}")
    public String excluirModulo(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            service.delete(id);
            attributes.addFlashAttribute(
                    "Mensagem Sucesso",
                    "Id Excluido com sucesso ");
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "Mensagem Erro",
                    "Erro ao excluir: Modulo com ID " + id + "não encontrado");
        } catch (Exception e) {
            attributes.addFlashAttribute(
                    "Mensagem Erro",
                    "Não foi possível excluir o modulo. Ele pode estar vinculado a outras tarefas.");
        }
        return "redirect:/listamodulo";
    }
}
