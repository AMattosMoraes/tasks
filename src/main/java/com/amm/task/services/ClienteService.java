package com.amm.task.services;

import com.amm.task.dto.ClienteDTO;
import com.amm.task.entities.Cliente;
import com.amm.task.mapper.ClienteMapper;
import com.amm.task.repositories.ClienteRepository;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private  ClienteMapper mapper;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable, String ativo) {
        Page<Cliente> page;
        if(ativo != null && !ativo.isEmpty()){
            page = repository.findByAtivo(ativo, pageable);
        } else {
            page = repository.findAll(pageable);
        }

        return page.map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        return mapper.toDto(entity);
    }

    @Transactional
    public ClienteDTO insert(ClienteDTO dto) {
        Cliente entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        entity.setAtivo(dto.getAtivo());
        entity.setInfo(dto.getInfo());
        entity.setContato(dto.getContato());
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourcesNotFoundExceptions(id);
        }
        repository.deleteById(id);
    }

}
