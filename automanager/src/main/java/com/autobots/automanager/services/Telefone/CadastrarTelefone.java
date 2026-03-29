package com.autobots.automanager.services.Telefone;

import com.autobots.automanager.dtos.request.TelefoneRequestDTO;
import com.autobots.automanager.dtos.response.TelefoneResponseDTO;
import com.autobots.automanager.mappers.TelefoneMapper;
import com.autobots.automanager.model.entity.Telefone;
import com.autobots.automanager.repository.TelefoneRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarTelefone {
    @Autowired
    private TelefoneRepositorio telefoneRepositorio;

    @Autowired
    private TelefoneMapper telefoneMapper;

    public TelefoneResponseDTO cadastrarTelefone(TelefoneRequestDTO DTO) {
        Telefone telefone = telefoneMapper.toEntity(DTO);
        Telefone telefoneSalvo = telefoneRepositorio.save(telefone);
        return telefoneMapper.toDTO(telefoneSalvo);
    }
}
