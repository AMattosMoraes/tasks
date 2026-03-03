package com.amm.task.resources;

import com.amm.task.entities.OrdemServico;
import com.amm.task.services.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ordemServicos")
public class OrdemServicoResources {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping
    public ResponseEntity<List<OrdemServico>> findAll(){
        List<OrdemServico> list = ordemServicoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServico> findById(@PathVariable Long id){
        OrdemServico obj = ordemServicoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
