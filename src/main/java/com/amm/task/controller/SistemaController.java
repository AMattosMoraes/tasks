package com.amm.task.controller;

import com.amm.task.dto.SistemaDTO;
import com.amm.task.mapper.SistemaMapper;
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
public class SistemaController {

    @Autowired
    private SistemaService service;

    @Autowired
    private SistemaMapper sistemaMapper;

    @GetMapping("/cadastrosistema")
    public String mostrarFormulario(Model model) {
        model.addAttribute("sistema", new SistemaDTO());
        return "cadastrosistema";
    }

    @GetMapping("/listasistema")
    public String ListarSistemas(
            Model model,
            @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<SistemaDTO> sistemaPage = service.findAll(pageable);

        model.addAttribute("listasistema", sistemaPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sistemaPage.getTotalPages());

        return "listasistema";
    }

    @PostMapping("/salvarsistema")
    public String salvarSistema(@ModelAttribute("sistema") SistemaDTO dto) {
        service.insert(dto);
        return "redirect:/listasistema";
    }

    @GetMapping("/editarsistema/{id}")
    public String editarSistema(Model model, @PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            SistemaDTO dto = service.findById(id);
            model.addAttribute("sistema", dto);
            return "editarsistema";
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "mensagemErro:",
                    "Não foi possivel editar: O Sistema com ID " + id + "não existe");
            return "editarsistema";
        }
    }

    @PostMapping("/atualizarsistema/{id}")
    public String atualizarSistema(@PathVariable("id") Long id, @ModelAttribute SistemaDTO dto, RedirectAttributes attributes) {
        try {
            dto.setId(id);
            service.update(id, dto);
            attributes.addFlashAttribute(
                    "mensagemSucesso",
                    "Sistema Atualizado com sucesso");
            return "redirect:/listasistema";
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "mensagemErro",
                    "Erro ao atualizar: O sistema não foi encontrado no banco de dados.");
            return "redirect:/listasistema";
        } catch (Exception e) {
            attributes.addFlashAttribute(
                    "mensagemErro",
                    "Erro inesperado ao salvar as alterações.");
            return "redirect:/listasistema";
        }
    }

    @GetMapping("/excluirsistema/{id}")
    public String excluirSistema(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try {
            service.delete(id);
            attributes.addFlashAttribute(
                    "Mensagem Sucesso",
                    "Id Excluido com sucesso ");
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "Mensagem Erro",
                    "Erro ao excluir: Sistema com ID " + id + "não encontrado");
        } catch (Exception e) {
            attributes.addFlashAttribute(
                    "Mensagem Erro",
                    "Não foi possível excluir o sistema. Ele pode estar vinculado a outras tarefas.");
        }
        return "redirect:/listasistema";
    }
}
