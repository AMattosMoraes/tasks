package com.amm.task.mapper;

import com.amm.task.dto.SistemaDTO;
import com.amm.task.entities.Sistema;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-02T22:25:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.18 (Amazon.com Inc.)"
)
@Component
public class SistemaMapperImpl implements SistemaMapper {

    @Override
    public SistemaDTO toDto(Sistema sistema) {
        if ( sistema == null ) {
            return null;
        }

        SistemaDTO sistemaDTO = new SistemaDTO();

        sistemaDTO.setId( sistema.getId() );
        sistemaDTO.setNome( sistema.getNome() );

        return sistemaDTO;
    }

    @Override
    public Sistema toEntity(SistemaDTO sistemaDTO) {
        if ( sistemaDTO == null ) {
            return null;
        }

        Sistema sistema = new Sistema();

        sistema.setId( sistemaDTO.getId() );
        sistema.setNome( sistemaDTO.getNome() );

        return sistema;
    }

    @Override
    public List<SistemaDTO> toDtoList(List<Sistema> sistemas) {
        if ( sistemas == null ) {
            return null;
        }

        List<SistemaDTO> list = new ArrayList<SistemaDTO>( sistemas.size() );
        for ( Sistema sistema : sistemas ) {
            list.add( toDto( sistema ) );
        }

        return list;
    }

    @Override
    public List<Sistema> toEntityList(List<SistemaDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Sistema> list = new ArrayList<Sistema>( dtos.size() );
        for ( SistemaDTO sistemaDTO : dtos ) {
            list.add( toEntity( sistemaDTO ) );
        }

        return list;
    }
}
