package com.amm.task.controller;

import com.amm.task.entities.OrdemServico;
import com.amm.task.repositories.ClienteRepository;
import com.amm.task.repositories.OrdemServicoRepository;
import com.amm.task.repositories.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrdemServicoController {

    @Autowired
    private final OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServicoController(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @GetMapping("/cadastroordemservico")
    public String mostrarFormulario(Model model){
        model.addAttribute("ordemservico", new OrdemServico());
        model.addAttribute("sistema", sistemaRepository.findAll());
        model.addAttribute("cliente", clienteRepository.findAll());
        return "cadastroordemservico";
    }

    @GetMapping("/listaordemservico")
    public String ListarOrdemServico(Model model, @RequestParam(defaultValue = "0") int page){
        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<OrdemServico> ordemServicoPage = ordemServicoRepository.findAll(pageable);

        model.addAttribute("listaordemservico", ordemServicoPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", ordemServicoPage.getTotalPages());

        return "listaordemservico";
    }

    @PostMapping("/salvarordemservico")
    public String salvarOrdemServico(@ModelAttribute OrdemServico ordemServico){
        ordemServicoRepository.save(ordemServico);
        return "redirect:/listaordemservico";
    }

    @GetMapping("/editarordemservico/{id}")
    public String editarOrdemServico(Model model, @PathVariable("id") Long id){
        OrdemServico ordemServico = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ordem de Serviço não encontrada" + id));
        model.addAttribute("ordemservico", ordemServico);
        return "editarordemservico";
    }

    @PostMapping("/atualizarordemservico/{id}")
    public String atualizarOrdemServico(@PathVariable("id") Long id, @ModelAttribute OrdemServico ordemServicoAtualizado) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ordem de Serviço não encontrada " + id));

        ordemServico.setOrdemstatus(ordemServico.getOrdemstatus());

        ordemServicoRepository.save(ordemServico);
        return "redirect:/listaordemservico";
    }

    @GetMapping("/excluirordemservico/{id}")
    public String excluirOrdemServico(@PathVariable("id") Long id) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ordem de Serviço não encontrada " + id));
        ordemServicoRepository.delete(ordemServico);
        return "redirect:/listaordemservico";
    }
}
