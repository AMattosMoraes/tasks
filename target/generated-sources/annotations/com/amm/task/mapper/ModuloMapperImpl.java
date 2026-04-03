package com.amm.task.mapper;

import com.amm.task.dto.ModuloDTO;
import com.amm.task.entities.Modulo;
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
public class ModuloMapperImpl implements ModuloMapper {

    @Override
    public ModuloDTO toDto(Modulo modulo) {
        if ( modulo == null ) {
            return null;
        }

        ModuloDTO moduloDTO = new ModuloDTO();

        moduloDTO.setId( modulo.getId() );
        moduloDTO.setDescSistema( modulo.getDescSistema() );
        moduloDTO.setDescModulo( modulo.getDescModulo() );

        return moduloDTO;
    }

    @Override
    public Modulo toEntity(ModuloDTO moduloDTO) {
        if ( moduloDTO == null ) {
            return null;
        }

        Modulo modulo = new Modulo();

        modulo.setId( moduloDTO.getId() );
        modulo.setDescSistema( moduloDTO.getDescSistema() );
        modulo.setDescModulo( moduloDTO.getDescModulo() );

        return modulo;
    }

    @Override
    public List<ModuloDTO> toDtoList(List<Modulo> modulos) {
        if ( modulos == null ) {
            return null;
        }

        List<ModuloDTO> list = new ArrayList<ModuloDTO>( modulos.size() );
        for ( Modulo modulo : modulos ) {
            list.add( toDto( modulo ) );
        }

        return list;
    }

    @Override
    public List<Modulo> toEntityList(List<ModuloDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Modulo> list = new ArrayList<Modulo>( dtos.size() );
        for ( ModuloDTO moduloDTO : dtos ) {
            list.add( toEntity( moduloDTO ) );
        }

        return list;
    }
}
