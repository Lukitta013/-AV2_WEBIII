package com.autobots.automanager.services.Documento;

import com.autobots.automanager.dtos.response.DocumentoResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.mappers.DocumentoMapper;
import com.autobots.automanager.repository.DocumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelecionarDoc {
    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    @Autowired
    private DocumentoMapper documentoMapper;

    public DocumentoResponseDTO selecionarDocumento(Long id){
        return documentoRepositorio.findById(id)
                .map(documento -> documentoMapper.totDTO(documento))
                .orElseThrow(()-> new RecursoNaoEncontradoException("Documento", id));
    }
}
