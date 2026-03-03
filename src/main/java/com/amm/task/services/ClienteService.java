package com.amm.task.services;

import com.amm.task.entities.Cliente;
import com.amm.task.repositories.ClienteRepository;
import com.amm.task.services.exceptions.DatabaseException;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente>findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundExceptions(id));
    }

    public Cliente insert(Cliente obj){
        return clienteRepository.save(obj);
    }

    public void delete(Long id){
        try {
            clienteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e ){
            throw new ResourcesNotFoundExceptions(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public Cliente update(Long id, Cliente obj){
        try {
            Cliente entity = clienteRepository.getReferenceById(id);
            updateData(entity, obj);
            return clienteRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourcesNotFoundExceptions(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResourcesNotFoundExceptions(id);
        }
    }

    private void updateData(Cliente entity, Cliente obj) {
        entity.setContato(obj.getContato());
        entity.setInfo(obj.getInfo());
    }

}
