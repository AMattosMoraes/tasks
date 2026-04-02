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
    private ModuloRepository moduloRepository;

    @Autowired
    private ModuloMapper moduloMapper;

    @Transactional(readOnly = true)
    public Page<ModuloDTO> findAll(Pageable pageable) {
        Page<Modulo> page = moduloRepository.findAll(pageable);
        return page.map(moduloMapper::toDto);
    }

    @Transactional(readOnly = true)
    public ModuloDTO findById(Long id){
        Modulo entity = moduloRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        return moduloMapper.toDto(entity);
    }

@Transactional
    public ModuloDTO insert(ModuloDTO dto){
        Modulo entity = moduloMapper.toEntity(dto);
        entity = moduloRepository.save(entity);
        return moduloMapper.toDto(entity);
    }

    @Transactional
    public ModuloDTO update(Long id, ModuloDTO dto){
        Modulo entity = moduloRepository.findById(id)
                        .orElseThrow(()-> new ResourcesNotFoundExceptions(id));
        entity.setDescModulo(dto.getDescModulo());
        entity.setDescSistema(dto.getDescSistema());
        entity =moduloRepository.save(entity);
        return moduloMapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id){
        if(!moduloRepository.existsById(id)){
            throw new ResourcesNotFoundExceptions(id);
        }
        moduloRepository.deleteById(id);
    }

}
