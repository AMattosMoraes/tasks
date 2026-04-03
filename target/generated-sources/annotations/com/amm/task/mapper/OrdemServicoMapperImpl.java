package com.amm.task.mapper;

import com.amm.task.dto.OrdemServicoDTO;
import com.amm.task.entities.OrdemServico;
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
public class OrdemServicoMapperImpl implements OrdemServicoMapper {

    @Override
    public OrdemServicoDTO toDto(OrdemServico ordemServico) {
        if ( ordemServico == null ) {
            return null;
        }

        OrdemServicoDTO ordemServicoDTO = new OrdemServicoDTO();

        ordemServicoDTO.setId( ordemServico.getId() );
        ordemServicoDTO.setOrdemstatus( ordemServico.getOrdemstatus() );
        ordemServicoDTO.setSetor( ordemServico.getSetor() );
        ordemServicoDTO.setDtcadastro( ordemServico.getDtcadastro() );
        ordemServicoDTO.setCliente( ordemServico.getCliente() );
        ordemServicoDTO.setPrioridade( ordemServico.getPrioridade() );
        ordemServicoDTO.setOrdem( ordemServico.getOrdem() );
        ordemServicoDTO.setSistema( ordemServico.getSistema() );
        ordemServicoDTO.setModulo( ordemServico.getModulo() );
        ordemServicoDTO.setResponsavel( ordemServico.getResponsavel() );
        ordemServicoDTO.setUsuario( ordemServico.getUsuario() );
        ordemServicoDTO.setTitulo( ordemServico.getTitulo() );
        ordemServicoDTO.setServico( ordemServico.getServico() );
        ordemServicoDTO.setTiposervico( ordemServico.getTiposervico() );
        ordemServicoDTO.setAnalistaresp( ordemServico.getAnalistaresp() );
        ordemServicoDTO.setSituacao( ordemServico.getSituacao() );
        ordemServicoDTO.setDtinicio( ordemServico.getDtinicio() );
        ordemServicoDTO.setHrinicio( ordemServico.getHrinicio() );
        ordemServicoDTO.setDtfinal( ordemServico.getDtfinal() );
        ordemServicoDTO.setHrfinal( ordemServico.getHrfinal() );

        return ordemServicoDTO;
    }

    @Override
    public OrdemServico toEntity(OrdemServicoDTO ordemServicoDTO) {
        if ( ordemServicoDTO == null ) {
            return null;
        }

        OrdemServico ordemServico = new OrdemServico();

        ordemServico.setId( ordemServicoDTO.getId() );
        ordemServico.setOrdemstatus( ordemServicoDTO.getOrdemstatus() );
        ordemServico.setSetor( ordemServicoDTO.getSetor() );
        ordemServico.setDtcadastro( ordemServicoDTO.getDtcadastro() );
        ordemServico.setCliente( ordemServicoDTO.getCliente() );
        ordemServico.setPrioridade( ordemServicoDTO.getPrioridade() );
        ordemServico.setOrdem( ordemServicoDTO.getOrdem() );
        ordemServico.setSistema( ordemServicoDTO.getSistema() );
        ordemServico.setModulo( ordemServicoDTO.getModulo() );
        ordemServico.setResponsavel( ordemServicoDTO.getResponsavel() );
        ordemServico.setUsuario( ordemServicoDTO.getUsuario() );
        ordemServico.setTitulo( ordemServicoDTO.getTitulo() );
        ordemServico.setServico( ordemServicoDTO.getServico() );
        ordemServico.setTiposervico( ordemServicoDTO.getTiposervico() );
        ordemServico.setAnalistaresp( ordemServicoDTO.getAnalistaresp() );
        ordemServico.setSituacao( ordemServicoDTO.getSituacao() );
        ordemServico.setDtinicio( ordemServicoDTO.getDtinicio() );
        ordemServico.setHrinicio( ordemServicoDTO.getHrinicio() );
        ordemServico.setDtfinal( ordemServicoDTO.getDtfinal() );
        ordemServico.setHrfinal( ordemServicoDTO.getHrfinal() );

        return ordemServico;
    }

    @Override
    public List<OrdemServicoDTO> toDtoList(List<OrdemServico> ordemServicos) {
        if ( ordemServicos == null ) {
            return null;
        }

        List<OrdemServicoDTO> list = new ArrayList<OrdemServicoDTO>( ordemServicos.size() );
        for ( OrdemServico ordemServico : ordemServicos ) {
            list.add( toDto( ordemServico ) );
        }

        return list;
    }

    @Override
    public List<OrdemServico> toEntityList(List<OrdemServicoDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<OrdemServico> list = new ArrayList<OrdemServico>( dtos.size() );
        for ( OrdemServicoDTO ordemServicoDTO : dtos ) {
            list.add( toEntity( ordemServicoDTO ) );
        }

        return list;
    }
}
