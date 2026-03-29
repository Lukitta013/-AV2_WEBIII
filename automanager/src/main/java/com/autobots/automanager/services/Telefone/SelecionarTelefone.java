package com.autobots.automanager.services.Telefone;

import com.autobots.automanager.dtos.response.TelefoneResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.mappers.TelefoneMapper;
import com.autobots.automanager.model.entity.Telefone;
import com.autobots.automanager.repository.TelefoneRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelecionarTelefone {
    @Autowired
    private TelefoneRepositorio telefoneRepositorio;

    @Autowired
    private TelefoneMapper telefoneMapper;

    public TelefoneResponseDTO selecionarTelefone(Long id) {
        return telefoneRepositorio.findById(id)
                .map(telefone -> telefoneMapper.toDTO(telefone))
                .orElseThrow(()-> new RecursoNaoEncontradoException("Telefone", id));
    }
}
