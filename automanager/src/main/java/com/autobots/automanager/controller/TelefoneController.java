package com.autobots.automanager.controller;

import com.autobots.automanager.dtos.request.TelefoneRequestDTO;
import com.autobots.automanager.dtos.response.TelefoneResponseDTO;
import com.autobots.automanager.model.entity.Telefone;
import com.autobots.automanager.services.Telefone.AlterarTelefone;
import com.autobots.automanager.services.Telefone.CadastrarTelefone;
import com.autobots.automanager.services.Telefone.ExcluirTelefone;
import com.autobots.automanager.services.Telefone.SelecionarTelefone;
import jakarta.validation.Valid;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelefoneController {
    @Autowired
    private CadastrarTelefone cadastrarTelefone;

    @Autowired
    private SelecionarTelefone selecionarTelefone;

    @Autowired
    private AlterarTelefone alterarTelefone;

    @Autowired
    private ExcluirTelefone excluirTelefone;

    @PostMapping("/cadastar/telefone")
    public ResponseEntity<TelefoneResponseDTO> cadastrarTelefone(@RequestBody @Valid TelefoneRequestDTO telefoneRequestDTO){
        TelefoneResponseDTO telefoneResponseDTO = cadastrarTelefone.cadastrarTelefone(telefoneRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefoneResponseDTO);
    }

    @GetMapping("/pegar/telefone")
    public ResponseEntity<TelefoneResponseDTO> pegarTelefone(@RequestParam("id") Long id){
        TelefoneResponseDTO resposta =  selecionarTelefone.selecionarTelefone(id);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PutMapping("/atualizar/telefone")
    public ResponseEntity<TelefoneResponseDTO> atualizarTelefone(@RequestParam(value = "id") Long id, TelefoneRequestDTO telefoneRequestDTO){
        TelefoneResponseDTO resposta = alterarTelefone.alterarTelefone(id, telefoneRequestDTO);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/telefone")
    public ResponseEntity<Void> excluirTelefone(@RequestParam(value = "id") Long id){
        excluirTelefone.excluirTelefone(id);
        return ResponseEntity.noContent().build();
    }
}
