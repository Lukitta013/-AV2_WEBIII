package com.autobots.automanager.model.entity;

import com.autobots.automanager.controller.ClienteController;
import com.autobots.automanager.dtos.response.DocumentoResponseDTO;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AdicionadorLinkDocumento implements AdicionadorLink<DocumentoResponseDTO> {

    @Override
    public void adicionarLink(DocumentoResponseDTO objeto) {
        Link linkCliente = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(ClienteController.class)
                        .listarClientes())
                .withRel("clientes");
        objeto.add(linkCliente);
    }

    @Override
    public void adicionarLink(List<DocumentoResponseDTO> lista) {
        lista.forEach(this::adicionarLink);
    }
}