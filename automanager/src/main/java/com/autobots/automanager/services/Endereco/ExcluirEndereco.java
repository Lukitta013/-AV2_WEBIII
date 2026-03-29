package com.autobots.automanager.services.Endereco;

import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.model.entity.Endereco;
import com.autobots.automanager.repository.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ExcluirEndereco {
    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    public void excluirEndereco(Long id) {
        Endereco endereco = enderecoRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente", id));
        enderecoRepositorio.delete(endereco);
    }
}

