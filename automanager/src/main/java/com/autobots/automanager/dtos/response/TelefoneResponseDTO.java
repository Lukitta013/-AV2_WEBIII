package com.autobots.automanager.dtos.response;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class TelefoneResponseDTO {

    private Long id;

    private String ddd;

    private String numero;

}
