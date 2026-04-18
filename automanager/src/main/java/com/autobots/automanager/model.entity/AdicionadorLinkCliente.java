package com.autobots.automanager.model.entity;

import com.autobots.automanager.controller.ClienteController;
import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AdicionadorLinkCliente implements AdicionadorLink<ClienteResponseDTO> {

    @Autowired
    private AdicionadorLinkDocumento adicionadorLinkDocumento;
    @Autowired
    private AdicionadorLinkEndereco adicionadorLinkEndereco;
    @Autowired
    private AdicionadorLinkTelefone adicionadorLinkTelefone;

    @Override
    public void adicionarLink(ClienteResponseDTO objeto) {
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(ClienteController.class)
                        .pegarCliente(objeto.getId()))
                .withSelfRel();
        objeto.add(selfLink);

        Link linkColecao = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(ClienteController.class)
                        .listarClientes())
                .withRel("clientes");
        objeto.add(linkColecao);

        if (objeto.getDocumentos() != null) {
            adicionadorLinkDocumento.adicionarLink(objeto.getDocumentos());
        }
        if (objeto.getEndereco() != null) {
            adicionadorLinkEndereco.adicionarLink(objeto.getEndereco());
        }
        if (objeto.getTelefones() != null) {
            adicionadorLinkTelefone.adicionarLink(objeto.getTelefones());
        }
    }

    @Override
    public void adicionarLink(List<ClienteResponseDTO> lista) {
        lista.forEach(this::adicionarLink);
    }
}