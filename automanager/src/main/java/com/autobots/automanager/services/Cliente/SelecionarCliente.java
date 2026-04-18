package com.autobots.automanager.services.Cliente;

import com.autobots.automanager.dtos.request.ClienteRequestDTO;
import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.mappers.ClienteMapper;
import com.autobots.automanager.model.entity.AdicionadorLinkCliente;
import com.autobots.automanager.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelecionarCliente {
    @Autowired private ClienteRepositorio clienteRepositorio;
    @Autowired private ClienteMapper clienteMapper;
    @Autowired private AdicionadorLinkCliente adicionadorLink;

    public ClienteResponseDTO selecionarCliente(Long id) {
        return clienteRepositorio.findById(id)
                .map(cliente -> {
                    ClienteResponseDTO dto = clienteMapper.toDTO(cliente);
                    adicionadorLink.adicionarLink(dto);
                    return dto;
                })
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente", id));
    }

    public List<ClienteResponseDTO> listarClientes() {
        List<ClienteResponseDTO> lista = clienteRepositorio.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
        adicionadorLink.adicionarLink(lista);
        return lista;
    }
}
