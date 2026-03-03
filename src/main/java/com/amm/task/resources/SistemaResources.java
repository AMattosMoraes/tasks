package com.amm.task.resources;

import com.amm.task.entities.Sistema;
import com.amm.task.services.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sistemas")
public class SistemaResources {

    @Autowired
    private SistemaService sistemaService;

    @GetMapping
    public ResponseEntity<List<Sistema>> findAll(){
//        Teste
//        Sistema s = new Sistema(1L,"Complab Advanced");
        List<Sistema> list = sistemaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sistema> findById(@PathVariable Long id){
        Sistema obj = sistemaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
