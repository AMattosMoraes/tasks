package com.amm.task.controller;

import com.amm.task.dto.ClienteDTO;
import com.amm.task.entities.Cliente;
import com.amm.task.mapper.ClienteMapper;
import com.amm.task.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/cadastrocliente")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "cadastrocliente";
    }

    @GetMapping("/listacliente")
    public String listarClientes(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(value = "ativo", required = false) String ativo
            ) {

        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
//        Page<Cliente> clientesPage = clienteRepository.findAll(pageable);
        Page<Cliente> clientesPage;

        if(ativo != null && !ativo.isEmpty()){
            clientesPage = clienteRepository.findByAtivo(ativo, pageable);
        } else {
            clientesPage = clienteRepository.findAll(pageable);
        }

        List<ClienteDTO> clientesDTO = ClienteMapper.toDTOList(clientesPage.getContent());

        model.addAttribute("listacliente", clientesDTO);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", clientesPage.getTotalPages());
        model.addAttribute("ativo", ativo);

        return "listacliente";
    }

    @PostMapping("/salvarcliente")
    public String salvarCliente(@ModelAttribute("cliente") ClienteDTO clienteDTO) {
        Cliente clienteSalva = ClienteMapper.toEntity(clienteDTO);
        clienteRepository.save(clienteSalva);

        return "redirect:/listacliente";
    }

    @GetMapping("/editarcliente/{id}")
    public String editarCliente(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado " + id));

        ClienteDTO clienteDTO = ClienteMapper.toDTO(cliente);

        model.addAttribute("cliente", clienteDTO);

        return "editarcliente";
    }

    @PostMapping("/atualizarcliente/{id}")
    public String atualizarCliente(@PathVariable("id") Long id, @ModelAttribute ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        Cliente clienteParaAtualizar = ClienteMapper.toEntity(clienteDTO);
        clienteRepository.save(clienteParaAtualizar);

        return "redirect:/listacliente";
    }

    @GetMapping("/excluircliente/{id}")
    public String excluirCliente(@PathVariable("id") Long id) {
        if(!clienteRepository.existsById(id)){
            throw new IllegalArgumentException("Cliente não encontrado "  + id);
        }
        clienteRepository.deleteById(id);

        return "redirect:/listacliente";
    }
}
