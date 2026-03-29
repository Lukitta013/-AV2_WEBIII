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

    public EnderecoResponseDTO alterarEndereco(Long id, EnderecoRequestDTO enderecoRequestDTO){
        Endereco endereco = enderecoRepositorio.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Endereço", id));
        endereco.setEstado(enderecoRequestDTO.getEstado());
        endereco.setCidade(enderecoRequestDTO.getCidade());
        endereco.setBairro(enderecoRequestDTO.getBairro());
        endereco.setRua(enderecoRequestDTO.getRua());
        endereco.setNumero(endereco.getNumero());
        endereco.setCodigoPostal(enderecoRequestDTO.getCodigoPostal());
        endereco.setInformacoesAdicionais(enderecoRequestDTO.getInformacoesAdicionais());

        Endereco atualizado = enderecoRepositorio.save(endereco);
        return enderecoMapper.toDTO(atualizado);
    }
}
