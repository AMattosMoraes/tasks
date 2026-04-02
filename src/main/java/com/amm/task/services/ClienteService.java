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
    private ClienteRepository clienteRepository;

    @Autowired
    private  ClienteMapper clienteMapper;

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable, String ativo) {
        Page<Cliente> page;
        if(ativo != null && !ativo.isEmpty()){
            page = clienteRepository.findByAtivo(ativo, pageable);
        } else {
            page = clienteRepository.findAll(pageable);
        }

        return page.map(clienteMapper::toDto);
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente entity = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        return clienteMapper.toDto(entity);
    }

    @Transactional
    public ClienteDTO insert(ClienteDTO dto) {
        Cliente entity = clienteMapper.toEntity(dto);
        entity = clienteRepository.save(entity);
        return clienteMapper.toDto(entity);
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente entity = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        entity.setAtivo(dto.getAtivo());
        entity.setInfo(dto.getInfo());
        entity.setContato(dto.getContato());
        entity = clienteRepository.save(entity);
        return clienteMapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourcesNotFoundExceptions(id);
        }
        clienteRepository.deleteById(id);
    }

}
