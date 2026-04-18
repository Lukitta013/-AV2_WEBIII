package com.autobots.automanager.model.entity;

import com.autobots.automanager.controller.ClienteController;
import com.autobots.automanager.dtos.response.EnderecoResponseDTO;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AdicionadorLinkEndereco implements AdicionadorLink<EnderecoResponseDTO> {

    @Override
    public void adicionarLink(EnderecoResponseDTO objeto) {
        Link linkCliente = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(ClienteController.class)
                        .listarClientes())
                .withRel("clientes");
        objeto.add(linkCliente);
    }

    @Override
    public void adicionarLink(List<EnderecoResponseDTO> lista) {
        lista.forEach(this::adicionarLink);
    }
}