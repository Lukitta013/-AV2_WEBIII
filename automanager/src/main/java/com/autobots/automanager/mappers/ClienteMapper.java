package com.autobots.automanager.mappers;

import com.autobots.automanager.dtos.request.ClienteRequestDTO;
import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import com.autobots.automanager.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DocumentoMapper.class, EnderecoMapper.class, TelefoneMapper.class})
public interface ClienteMapper {
    ClienteResponseDTO toDTO(Cliente cliente);
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDTO clienteRequestDTO);
}
