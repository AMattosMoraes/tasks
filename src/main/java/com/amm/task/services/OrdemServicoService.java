package com.amm.task.services;

import com.amm.task.entities.OrdemServico;
import com.amm.task.repositories.OrdemServicoRepository;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public List<OrdemServico>findAll(){
        return ordemServicoRepository.findAll();
    }

    public OrdemServico findById(Long id){
        Optional<OrdemServico> obj = ordemServicoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundExceptions(id));
    }

    public OrdemServico insert(OrdemServico obj){
        return ordemServicoRepository.save(obj);
    }

    public void delete(Long id){
        ordemServicoRepository.deleteById(id);
    }

}
