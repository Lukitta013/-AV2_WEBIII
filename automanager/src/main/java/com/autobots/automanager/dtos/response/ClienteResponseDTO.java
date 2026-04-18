package com.autobots.automanager.dtos.response;

import com.autobots.automanager.dtos.request.DocumentoRequestDTO;
import com.autobots.automanager.dtos.request.EnderecoRequestDTO;
import com.autobots.automanager.dtos.request.TelefoneRequestDTO;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
public class ClienteResponseDTO extends RepresentationModel<ClienteResponseDTO> {
    private Long id;

    private String nome;

    private String nomeSocial;

    private Date dataNascimento;

    private Date dataCadastro;

    private List<DocumentoResponseDTO> documentos;

    private EnderecoResponseDTO endereco;

    private List<TelefoneResponseDTO> telefones;
}
