package com.autobots.automanager.dtos.response;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

@Data
public class DocumentoResponseDTO extends RepresentationModel<DocumentoResponseDTO> {
    private String id;

    private String tipo;

    private String numero;
}
