package com.amm.task.controller;

import com.amm.task.entities.Cliente;
import com.amm.task.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@Controller
public class ClienteController {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/cadastrocliente")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastrocliente";
    }

//    @GetMapping("/listacliente")
//    public String ListarClientes(Model model) {
//        model.addAttribute("listacliente", clienteRepository.findAll());
//        return "listacliente";
//    }

    // Modificado para paginar a pagina de listar cliente (15 por pagina)
    @GetMapping("/listacliente")
    public String listarClientes(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<Cliente> clientesPage = clienteRepository.findAll(pageable);

        model.addAttribute("listacliente", clientesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", clientesPage.getTotalPages());

        return "listacliente";
    }

    @PostMapping("/salvarcliente")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/listacliente";
    }

    @GetMapping("/editarcliente/{id}")
    public String editarCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado " + id));
        model.addAttribute("cliente", cliente);
        return "editarcliente";
    }

    @PostMapping("/atualizarcliente/{id}")
    public String atualizarCliente(@PathVariable("id") Long id, @ModelAttribute Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado " + id));

        cliente.setCnpj(clienteAtualizado.getCnpj());
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setUf(clienteAtualizado.getUf());
        cliente.setContato(clienteAtualizado.getContato());
        cliente.setInfo(clienteAtualizado.getInfo());

        clienteRepository.save(cliente);
        return "redirect:/listacliente";
    }

    @GetMapping("/excluircliente/{id}")
    public String excluirCliente(@PathVariable("id") Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado " + id));
        clienteRepository.delete(cliente);
        return "redirect:/listacliente";
    }
}
