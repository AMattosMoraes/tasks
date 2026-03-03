package com.amm.task.controller;

import com.amm.task.repositories.OrdemServicoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdemServicoController {

    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoController(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @GetMapping("/listaordemservico")
    public String ListarOrdemServico(Model model){
        model.addAttribute("listaordemservico", ordemServicoRepository.findAll());
        return "listaordemservico";
    }

}
