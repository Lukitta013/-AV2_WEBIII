package com.autobots.automanager.services.Cliente;

import com.autobots.automanager.dtos.request.ClienteRequestDTO;
import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import com.autobots.automanager.mappers.ClienteMapper;
import com.autobots.automanager.model.entity.Cliente;
import com.autobots.automanager.repository.ClienteRepositorio;
import com.autobots.automanager.repository.DocumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraCliente {

    @Autowired
    private ClienteRepositorio clienteRepositorio;


    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponseDTO criarCliente(ClienteRequestDTO DTO) {
        Cliente cliente =  clienteMapper.toEntity(DTO); //Salva sem id, dto virou entidade, aquela do banco de dados.
        Cliente clienteSalvo = clienteRepositorio.save(cliente); // A entidade foi pro banco, se deu certo, vorta com o ID
        return clienteMapper.toDTO(clienteSalvo);
    }




    }

// https://www.youtube.com/watch?v=8HVLFySv1yQ