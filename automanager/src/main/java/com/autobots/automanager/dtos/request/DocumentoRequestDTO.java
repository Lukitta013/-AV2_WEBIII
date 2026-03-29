package com.autobots.automanager.dtos.request;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class DocumentoRequestDTO {
    @NotBlank
    private String tipo;

    @NotNull
    private String numero;
}
