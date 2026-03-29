package com.autobots.automanager.services.Cliente;

import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.model.entity.Cliente;
import com.autobots.automanager.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcluirCLiente {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public void excluirCliente(Long id){
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Cliente", id));
        clienteRepositorio.delete(cliente);
    }
}
