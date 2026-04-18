package com.autobots.automanager.services.Endereco;

import com.autobots.automanager.dtos.request.EnderecoRequestDTO;
import com.autobots.automanager.dtos.response.EnderecoResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.mappers.EnderecoMapper;
import com.autobots.automanager.model.entity.Documento;
import com.autobots.automanager.model.entity.Endereco;
import com.autobots.automanager.repository.ClienteRepositorio;
import com.autobots.automanager.repository.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterarEndereco {
    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    @Autowired
    EnderecoMapper enderecoMapper;

    public EnderecoResponseDTO alterarEndereco(Long id, EnderecoRequestDTO dto) {
        Endereco endereco = enderecoRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Endereço", id));
        endereco.setEstado(dto.getEstado());
        endereco.setCidade(dto.getCidade());
        endereco.setBairro(dto.getBairro());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero()); // estava pegando do próprio endereco!
        endereco.setCodigoPostal(dto.getCodigoPostal());
        endereco.setInformacoesAdicionais(dto.getInformacoesAdicionais());
        return enderecoMapper.toDTO(enderecoRepositorio.save(endereco));
    }
}
