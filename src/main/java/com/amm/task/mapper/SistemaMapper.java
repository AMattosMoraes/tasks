package com.amm.task.mapper;

import com.amm.task.dto.SistemaDTO;
import com.amm.task.entities.Sistema;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SistemaMapper {

    SistemaDTO toDto(Sistema sistema);

    Sistema toEntity(SistemaDTO sistemaDTO);

    List<SistemaDTO> toDtoList(List<Sistema> sistemas);

    List<Sistema> toEntityList(List<SistemaDTO> dtos);

}
