package com.amm.task.services;

import com.amm.task.dto.ModuloDTO;
import com.amm.task.entities.Modulo;
import com.amm.task.mapper.ModuloMapper;
import com.amm.task.repositories.ModuloRepository;
import com.amm.task.services.exceptions.ResourcesNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository repository;

    @Autowired
    private ModuloMapper mapper;

    @Transactional(readOnly = true)
    public Page<ModuloDTO> findAll(Pageable pageable) {
        Page<Modulo> page = repository.findAll(pageable);
        return page.map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public ModuloDTO findById(Long id){
        Modulo entity = repository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        return mapper.toDto(entity);
    }

@Transactional
    public ModuloDTO insert(ModuloDTO dto){
        Modulo entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public ModuloDTO update(Long id, ModuloDTO dto){
        Modulo entity = repository.findById(id)
                        .orElseThrow(()-> new ResourcesNotFoundExceptions(id));
        entity.setDescModulo(dto.getDescModulo());
        entity.setDescSistema(dto.getDescSistema());
        entity =repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourcesNotFoundExceptions(id);
        }
        repository.deleteById(id);
    }

}
