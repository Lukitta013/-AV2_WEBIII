package com.autobots.automanager.dtos.request;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class TelefoneRequestDTO {
    @NotBlank
    private String ddd;

    @NotBlank
    private String numero;

}
