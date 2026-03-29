package com.autobots.automanager.services.Cliente;

import com.autobots.automanager.dtos.request.ClienteRequestDTO;
import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.mappers.ClienteMapper;
import com.autobots.automanager.model.entity.Cliente;
import com.autobots.automanager.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterarCliente {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponseDTO alterarCliente(Long id, ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Cliente", id));
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setNomeSocial(clienteRequestDTO.getNomeSocial());
        cliente.setDataNascimento(clienteRequestDTO.getDataNascimento());
        cliente.setDataCadastro(clienteRequestDTO.getDataCadastro());

        Cliente atualizado = clienteRepositorio.save(cliente);
        return clienteMapper.toDTO(atualizado);

    }
}
