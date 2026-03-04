package com.amm.task.mapper;

import com.amm.task.dto.ClienteDTO;
import com.amm.task.entities.Cliente;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClienteMapper {

    // Converte entidade para DTO
    public static ClienteDTO toDTO(Cliente cliente){
        if(cliente == null){
            return null;
        }
        return new ClienteDTO(cliente);
    }

    // Converte DTO para entidade
    public static Cliente toEntity(ClienteDTO dto){
        if(dto == null){
            return null;
        }
        return new Cliente(
                dto.getId(),
                dto.getCnpj(),
                dto.getNome(),
                dto.getUf(),
                dto.getContato(),
                dto.getInfo()
        );
    }

    // Converte lista de entidades para lista de DTOs
    public static List<ClienteDTO> toDTOList(List<Cliente> clientes){
        return clientes.stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Converte lista de DTOs para entidades
    public static List<Cliente> toEntityList(List<ClienteDTO> dtos){
        return dtos.stream()
                .map(ClienteMapper::toEntity)
                .collect(Collectors.toList());
    }
}
