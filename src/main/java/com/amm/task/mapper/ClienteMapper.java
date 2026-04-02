package com.amm.task.mapper;

import com.amm.task.dto.ClienteDTO;
import com.amm.task.dto.ClienteDTO;
import com.amm.task.entities.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDTO toDto(Cliente cliente);

    Cliente toEntity(ClienteDTO clienteDTO);

    List<ClienteDTO> toDtoList(List<Cliente> clientes);

    List<Cliente> toEntityList(List<ClienteDTO> dtos);    
}
