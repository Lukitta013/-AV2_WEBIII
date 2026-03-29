package com.autobots.automanager.dtos.response;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
@Data
public class DocumentoResponseDTO {
    private String id;

    private String tipo;

    private String numero;
}
