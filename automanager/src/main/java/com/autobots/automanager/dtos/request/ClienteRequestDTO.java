package com.autobots.automanager.dtos.request;

import com.autobots.automanager.model.entity.Endereco;
import lombok.Data;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ClienteRequestDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String nomeSocial;

    @NotNull
    private Date dataNascimento;

    @NotNull
    private Date dataCadastro;

    @NotNull
    private List<DocumentoRequestDTO> documentos;

    @NotNull
    private EnderecoRequestDTO endereco;

    @NotNull
    private List<TelefoneRequestDTO> telefones;






}
