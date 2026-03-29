package com.autobots.automanager.services.Documento;

import com.autobots.automanager.dtos.request.DocumentoRequestDTO;
import com.autobots.automanager.dtos.response.DocumentoResponseDTO;
import com.autobots.automanager.mappers.DocumentoMapper;
import com.autobots.automanager.model.entity.Documento;
import com.autobots.automanager.repository.DocumentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarDoc {
    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    @Autowired
    private DocumentoMapper documentoMapper;

    public DocumentoResponseDTO criarDocumento(DocumentoRequestDTO DTO) {
        Documento documento = documentoMapper.toEntity(DTO);
        Documento docSalvo = documentoRepositorio.save(documento);
        return documentoMapper.totDTO(docSalvo);
    }
}
