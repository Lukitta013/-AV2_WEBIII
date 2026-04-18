package com.autobots.automanager.controller;

import com.autobots.automanager.dtos.request.DocumentoRequestDTO;
import com.autobots.automanager.dtos.response.DocumentoResponseDTO;
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
    @Autowired private SelecionarDoc selecionarDoc;
    @Autowired private AlterarDoc alterarDoc;
    @Autowired private ExcluirDoc excluirDoc;

    @PostMapping
    public ResponseEntity<DocumentoResponseDTO> cadastrar(@RequestBody @Valid DocumentoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrarDoc.criarDocumento(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoResponseDTO> pegar(@PathVariable Long id) {
        return ResponseEntity.ok(selecionarDoc.selecionarDocumento(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentoResponseDTO> atualizar(@PathVariable Long id,
                                                          @RequestBody @Valid DocumentoRequestDTO dto) {
        return ResponseEntity.ok(alterarDoc.alterarDocumento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        excluirDoc.excluirDocumento(id);
        return ResponseEntity.noContent().build();
        //Em vez de você ficar pensando nele
        //Em vez de você viver chorando por ele
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pra ele, não chore por ele
        //
        //Se lembre que eu há muito tempo te amo
        //Te amo, te amo
        //Quero fazer você feliz
        //Vamos pegar o primeiro avião
        //Com destino à felicidade
        //A felicidade pra mim é você
        //
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pra ele, não chore por ele
        //
        //Se lembre que eu há muito tempo te amo
        //Te amo, te amo
        //Quero fazer você feliz
        //Vamos pegar o primeiro avião
        //Com destino à felicidade
        //A felicidade pra mim é você
        //
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pra ele, não chore por ele
        //
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pense em mim, chore por mim
        //Liga pra mim, não, não liga pra ele
        //Pra ele, não chore por ele
        //
        //Pense em mim, chore por mim
    }
}