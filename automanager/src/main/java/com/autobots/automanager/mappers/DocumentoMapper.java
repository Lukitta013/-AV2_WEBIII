package com.autobots.automanager.mappers;

import com.autobots.automanager.dtos.request.DocumentoRequestDTO;
import com.autobots.automanager.dtos.response.DocumentoResponseDTO;
import com.autobots.automanager.model.entity.Documento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
    DocumentoResponseDTO totDTO(Documento documento);
    @Mapping(target = "id", ignore = true)
    Documento toEntity(DocumentoRequestDTO documentoRequestDTO);
}
