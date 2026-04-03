package com.amm.task.controller;

import com.amm.task.dto.ClienteDTO;
import com.amm.task.entities.Cliente;
import com.amm.task.mapper.ClienteMapper;
import com.amm.task.repositories.ClienteRepository;
import com.amm.task.services.ClienteService;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteMapper mapper;

    @GetMapping("/cadastrocliente")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "cadastrocliente";
    }

    @GetMapping("/listacliente")
    public String listarClientes(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            String ativo) {
        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<ClienteDTO> clientesPage = service.findAll(pageable, ativo);


        model.addAttribute("listacliente", clientesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", clientesPage.getTotalPages());
        model.addAttribute("totalElements",clientesPage.getTotalElements());
        model.addAttribute("ativo", ativo);

        return "listacliente";
    }

    @PostMapping("/salvarcliente")
    public String salvarCliente(@ModelAttribute("cliente") ClienteDTO dto) {
        service.insert(dto);
        return "redirect:/listacliente";
    }

    @GetMapping("/editarcliente/{id}")
    public String editarCliente(Model model, @PathVariable("id") Long id, RedirectAttributes attributes) {
        try{
            ClienteDTO dto = service.findById(id);
            model.addAttribute("cliente", dto);
            return "editarcliente";
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "mensagemErro:",
                    "Não foi possivel editar: O Cliente com ID " + id + "não existe");
            return "editarcliente";
        }
    }

    @PostMapping("/atualizarcliente/{id}")
    public String atualizarCliente(@PathVariable("id") Long id, @ModelAttribute ClienteDTO dto, RedirectAttributes attributes) {
        try{
            dto.setId(id);
            service.update(id, dto);
            attributes.addFlashAttribute(
                    "mensagemSucesso",
                    "Cliente Atualizado com sucesso");
            return "redirect:/listacliente";
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "mensagemErro",
                    "Erro ao atualizar: O cliente não foi encontrado no banco de dados.");
            return "redirect:/listacliente";
        } catch (Exception e) {
            attributes.addFlashAttribute(
                    "mensagemErro",
                    "Erro inesperado ao salvar as alterações.");
            return "redirect:/listacliente";
        }
    }

    @GetMapping("/excluircliente/{id}")
    public String excluirCliente(@PathVariable("id") Long id, RedirectAttributes attributes) {
        try{
            service.delete(id);
            attributes.addFlashAttribute(
                    "Mensagem Sucesso",
                    "Id Excluido com sucesso ");
        } catch (ResourcesNotFoundExceptions e) {
            attributes.addFlashAttribute(
                    "Mensagem Erro",
                    "Erro ao excluir: Cliente com ID " + id + "não encontrado");
        } catch (Exception e) {
            attributes.addFlashAttribute(
                    "Mensagem Erro",
                    "Não foi possível excluir o cliente. Ele pode estar vinculado a outras tarefas.");
        }
        return "redirect:/listacliente";
    }
}
