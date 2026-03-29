package com.autobots.automanager.services.Cliente;

import com.autobots.automanager.dtos.request.ClienteRequestDTO;
import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.mappers.ClienteMapper;
import com.autobots.automanager.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SelecionarCliente {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponseDTO selecionarCliente(Long id){
     return clienteRepositorio.findById(id)
             .map(cliente -> clienteMapper.toDTO(cliente)) // Mapper converte entidade para dto
             .orElseThrow(()-> new RecursoNaoEncontradoException("Cliente", id));
    }
}
