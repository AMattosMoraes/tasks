package com.amm.task.mapper;

import com.amm.task.dto.ClienteDTO;
import com.amm.task.entities.Cliente;
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
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO toDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( cliente.getId() );
        clienteDTO.setCnpj( cliente.getCnpj() );
        clienteDTO.setNome( cliente.getNome() );
        clienteDTO.setUf( cliente.getUf() );
        clienteDTO.setContato( cliente.getContato() );
        clienteDTO.setInfo( cliente.getInfo() );
        clienteDTO.setAtivo( cliente.getAtivo() );

        return clienteDTO;
    }

    @Override
    public Cliente toEntity(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDTO.getId() );
        cliente.setCnpj( clienteDTO.getCnpj() );
        cliente.setNome( clienteDTO.getNome() );
        cliente.setUf( clienteDTO.getUf() );
        cliente.setContato( clienteDTO.getContato() );
        cliente.setInfo( clienteDTO.getInfo() );
        cliente.setAtivo( clienteDTO.getAtivo() );

        return cliente;
    }

    @Override
    public List<ClienteDTO> toDtoList(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( toDto( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toEntityList(List<ClienteDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( dtos.size() );
        for ( ClienteDTO clienteDTO : dtos ) {
            list.add( toEntity( clienteDTO ) );
        }

        return list;
    }
}
