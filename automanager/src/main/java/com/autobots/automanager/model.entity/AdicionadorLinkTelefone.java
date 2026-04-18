package com.autobots.automanager.model.entity;

import com.autobots.automanager.controller.ClienteController;
import com.autobots.automanager.dtos.response.TelefoneResponseDTO;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AdicionadorLinkTelefone implements AdicionadorLink<TelefoneResponseDTO> {

    @Override
    public void adicionarLink(TelefoneResponseDTO objeto) {
        Link linkCliente = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(ClienteController.class)
                        .listarClientes())
                .withRel("clientes");
        objeto.add(linkCliente);
    }

    @Override
    public void adicionarLink(List<TelefoneResponseDTO> lista) {
        lista.forEach(this::adicionarLink);
    }
}