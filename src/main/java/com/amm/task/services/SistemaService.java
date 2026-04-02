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

@Service
public class SistemaService {

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private SistemaMapper sistemaMapper;

    @Transactional(readOnly = true)
    public Page<SistemaDTO> findAll(Pageable pageable) {
        Page<Sistema> page = sistemaRepository.findAll(pageable);
        return page.map(sistemaMapper::toDto);
    }

    @Transactional(readOnly = true)
    public SistemaDTO findById(Long id) {
        Sistema entity = sistemaRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        return sistemaMapper.toDto(entity);
    }

    @Transactional
    public SistemaDTO insert(SistemaDTO dto) {
        Sistema entity = sistemaMapper.toEntity(dto);
        entity = sistemaRepository.save(entity);
        return sistemaMapper.toDto(entity);
    }

    @Transactional
    public SistemaDTO update(Long id, SistemaDTO dto) {
        Sistema entity = sistemaRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundExceptions(id));
        entity.setNome(dto.getNome());
        entity = sistemaRepository.save(entity);
        return sistemaMapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        if (!sistemaRepository.existsById(id)) {
            throw new ResourcesNotFoundExceptions(id);
        }
        sistemaRepository.deleteById(id);
    }

}
