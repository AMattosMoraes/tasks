package com.amm.task.mapper;

import com.amm.task.dto.ModuloDTO;
import com.amm.task.entities.Modulo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuloMapper {

    ModuloDTO toDto(Modulo modulo);

    Modulo toEntity(ModuloDTO moduloDTO);

    List<ModuloDTO> toDtoList(List<Modulo> modulos);

    List<Modulo> toEntityList(List<ModuloDTO> dtos);

}
