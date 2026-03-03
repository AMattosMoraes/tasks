package com.amm.task.controller;

import com.amm.task.entities.Sistema;
import com.amm.task.repositories.SistemaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SistemaController {

    private final SistemaRepository sistemaRepository;

    public SistemaController(SistemaRepository sistemaRepository) {
        this.sistemaRepository = sistemaRepository;
    }

    @GetMapping("/cadastrosistema")
    public String mostrarFormulario(Model model) {
        model.addAttribute("sistema", new Sistema());
        return "cadastrosistema";
    }

    @GetMapping("/listasistema")
    public String ListarSistemas(Model model, @RequestParam(defaultValue = "0") int page){
        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<Sistema> sistemaPage = sistemaRepository.findAll(pageable);

        model.addAttribute("listasistema", sistemaPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sistemaPage.getTotalPages());

        return "listasistema";
    }

    @PostMapping("/salvarsistema")
    public String salvarSistema(@ModelAttribute Sistema sistema) {
        sistemaRepository.save(sistema);
        return "redirect:/listasistema";
    }

    @GetMapping("/editarsistema/{id}")
    public String editarSistema(@PathVariable("id") Long id, Model model) {
        Sistema sistema = sistemaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sistema não encontrado " + id));
        model.addAttribute("sistema", sistema);
        return "editarsistema";
    }

    @PostMapping("/atualizarsistema/{id}")
    public String atualizarSistema(@PathVariable("id") Long id, @ModelAttribute Sistema sistemaAtualizado) {
        Sistema sistema = sistemaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sistema não encontrado " + id));

        sistema.setNome(sistemaAtualizado.getNome());

        sistemaRepository.save(sistema);
        return "redirect:/listasistema";
    }

    @GetMapping("/excluirsistema/{id}")
    public String excluirSistema(@PathVariable("id") Long id) {
        Sistema sistema = sistemaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sistema não encontrado " + id));
        sistemaRepository.delete(sistema);
        return "redirect:/listasistema";
    }
}
