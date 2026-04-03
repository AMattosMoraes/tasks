package com.amm.task.mapper;

import com.amm.task.dto.OrdemServicoDTO;
import com.amm.task.entities.OrdemServico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdemServicoMapper {

    OrdemServicoDTO toDto(OrdemServico ordemServico);

    OrdemServico toEntity(OrdemServicoDTO ordemServicoDTO);

    List<OrdemServicoDTO> toDtoList(List<OrdemServico> ordemServicos);

    List<OrdemServico> toEntityList(List<OrdemServicoDTO> dtos);
}
