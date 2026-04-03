package com.amm.task.services;

import com.amm.task.dto.SistemaDTO;
import com.amm.task.entities.Sistema;
import com.amm.task.mapper.SistemaMapper;
import com.amm.task.repositories.SistemaRepository;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SistemaService {

    @Autowired
    private SistemaRepository repository;

    @Autowired
    private SistemaMapper mapper;

    @Transactional(readOnly = true)
    public Page<SistemaDTO> findAll(Pageable pageable) {
        Page<Sistema> page = repository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public SistemaDTO findById(Long id) {
        Sistema entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        return mapper.toDto(entity);
    }

    @Transactional
    public SistemaDTO insert(SistemaDTO dto) {
        Sistema entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public SistemaDTO update(Long id, SistemaDTO dto) {
        Sistema entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        entity.setNome(dto.getNome());
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

    @Transactional(readOnly = true)
    public List<SistemaDTO> listarTodos(){
        List<Sistema> list = repository.findAll();
        return list.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
