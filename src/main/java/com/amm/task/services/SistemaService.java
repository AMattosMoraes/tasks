package com.amm.task.services;

import com.amm.task.entities.Sistema;
import com.amm.task.repositories.SistemaRepository;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaService {

    @Autowired
    private SistemaRepository sistemaRepository;

    public List<Sistema>findAll(){
        return sistemaRepository.findAll();
    }

    public Sistema findById(Long id){
        Optional<Sistema> obj = sistemaRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundExceptions(id));
    }

    public Sistema insert(Sistema obj){
        return sistemaRepository.save(obj);
    }

    public void delete(Long id){
        sistemaRepository.deleteById(id);
    }

}
