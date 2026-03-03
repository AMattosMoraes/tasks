package com.amm.task.services;

import com.amm.task.entities.Modulo;
import com.amm.task.repositories.ModuloRepository;
import com.amm.task.services.exceptions.DatabaseException;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<Modulo>findAll(){
        return moduloRepository.findAll();
    }

    public Modulo findById(Long id){
        Optional<Modulo> obj = moduloRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundExceptions(id));
    }

    public Modulo insert(Modulo obj){
        return moduloRepository.save(obj);
    }

    public void delete(Long id){
        try {
            moduloRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e ){
            throw new ResourcesNotFoundExceptions(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public Modulo update(Long id, Modulo obj){
        try {
            Modulo entity = moduloRepository.getReferenceById(id);
            updateData(entity, obj);
            return moduloRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourcesNotFoundExceptions(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResourcesNotFoundExceptions(id);
        }
    }

    private void updateData(Modulo entity, Modulo obj) {
        entity.setDescsistema(obj.getDescsistema());
        entity.setDescmodulo(obj.getDescmodulo());
    }

}
