package com.amm.task.controller;

import com.amm.task.entities.Modulo;
import com.amm.task.repositories.ModuloRepository;
import com.amm.task.services.ModuloService;
import com.amm.task.services.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ModuloController {

    private final ModuloRepository moduloRepository;

    @Autowired
    private ModuloService moduloService;

    @Autowired
    private SistemaService sistemaService;

    public ModuloController(ModuloRepository moduloRepository) {
        this.moduloRepository = moduloRepository;
    }

    @GetMapping("/cadastromodulo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("sistema", sistemaService.findAll());
        model.addAttribute("modulo", new Modulo());
        return "cadastromodulo";
    }

    @GetMapping("/listamodulo")
    public String listarModulos(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<Modulo> moduloPage = moduloRepository.findAll(pageable);

        model.addAttribute("listamodulo", moduloPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moduloPage.getTotalPages());

        return "listamodulo";
    }

    @PostMapping("/salvarmodulo")
    public String salvarModulo(@ModelAttribute Modulo modulo) {
        moduloRepository.save(modulo);
        return "redirect:/listamodulo";
    }

    @GetMapping("/editarmodulo/{id}")
    public String editarModulo(@PathVariable("id") Long id, Model model) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Modulo não encontrado " + id));
        model.addAttribute("modulo", modulo);
        return "editarmodulo";
    }

    @PostMapping("/atualizarmodulo/{id}")
    public String atualizarModulo(@PathVariable("id") Long id, @ModelAttribute Modulo moduloAtualizado) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Modulo não encontrado " + id));

        modulo.setDescsistema(moduloAtualizado.getDescsistema());
        modulo.setDescmodulo(moduloAtualizado.getDescmodulo());

        moduloRepository.save(modulo);
        return "redirect:/listamodulo";
    }

    @GetMapping("/excluirmodulo/{id}")
    public String excluirModulo(@PathVariable("id") Long id) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Modulo não encontrado " + id));
        moduloRepository.delete(modulo);
        return "redirect:/listamodulo";
    }
}
