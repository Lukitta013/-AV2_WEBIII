package com.autobots.automanager.controller;

import com.autobots.automanager.dtos.request.DocumentoRequestDTO;
import com.autobots.automanager.dtos.response.DocumentoResponseDTO;
import com.autobots.automanager.model.entity.Documento;
import com.autobots.automanager.repository.DocumentoRepositorio;
import com.autobots.automanager.services.Documento.AlterarDoc;
import com.autobots.automanager.services.Documento.CadastrarDoc;
import com.autobots.automanager.services.Documento.ExcluirDoc;
import com.autobots.automanager.services.Documento.SelecionarDoc;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docs")
public class DocumentoController {
    @Autowired
    private CadastrarDoc cadastrarDoc;

    @Autowired
    private SelecionarDoc selecionarDoc;

    @Autowired
    private AlterarDoc alterarDoc;

    @Autowired
    private ExcluirDoc excluirDoc;

    @PostMapping("/cadastrar/documento")
    public ResponseEntity<DocumentoResponseDTO> cadastrarDocumento(@RequestBody DocumentoRequestDTO documentoRequestDTO){
        DocumentoResponseDTO resposta = cadastrarDoc.criarDocumento(documentoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping("/pegar/docuumento")
    public ResponseEntity<DocumentoResponseDTO> pegarDocumento(@RequestParam("id") Long id){
        DocumentoResponseDTO resposta = selecionarDoc.selecionarDocumento(id);
        return new  ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PutMapping("/atualizar/documento")
    public ResponseEntity<DocumentoResponseDTO>  atualizarDocumento(@RequestParam(value = "id") Long id, @RequestBody @Valid DocumentoRequestDTO documentoRequestDTO){
        DocumentoResponseDTO resposta = alterarDoc.alterarDocumento(id, documentoRequestDTO);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/documento")
    public ResponseEntity<Void> excluirDocumento(@RequestParam(value = "id") Long id){
        excluirDoc.excluirDocumento(id);
        return ResponseEntity.noContent().build();
    }
}
