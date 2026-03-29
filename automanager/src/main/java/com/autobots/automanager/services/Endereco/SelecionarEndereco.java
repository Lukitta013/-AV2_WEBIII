package com.autobots.automanager.services.Endereco;

import com.autobots.automanager.dtos.response.DocumentoResponseDTO;
import com.autobots.automanager.dtos.response.EnderecoResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.mappers.DocumentoMapper;
import com.autobots.automanager.mappers.EnderecoMapper;
import com.autobots.automanager.repository.DocumentoRepositorio;
import com.autobots.automanager.repository.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelecionarEndereco {
    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public EnderecoResponseDTO selecionarDocumento(Long id) {
        return enderecoRepositorio.findById(id)
                .map(endereco -> enderecoMapper.toDTO(endereco))
                .orElseThrow(()-> new RecursoNaoEncontradoException("Endereço", id));
    }
}
