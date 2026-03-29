package com.autobots.automanager.controller;

import com.autobots.automanager.dtos.request.EnderecoRequestDTO;
import com.autobots.automanager.dtos.response.EnderecoResponseDTO;
import com.autobots.automanager.services.Endereco.AlterarEndereco;
import com.autobots.automanager.services.Endereco.CadastrarEndereco;
import com.autobots.automanager.services.Endereco.ExcluirEndereco;
import com.autobots.automanager.services.Endereco.SelecionarEndereco;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private CadastrarEndereco cadastrarEndereco;

    @Autowired
    private SelecionarEndereco selecionarEndereco;

    @Autowired
    private AlterarEndereco alterarEndereco;

    @Autowired
    private ExcluirEndereco excluirEndereco;

    @PostMapping("/cadastrar/endereco")
    public ResponseEntity<EnderecoResponseDTO> criarEndereco(@RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO){
        EnderecoResponseDTO resposta = cadastrarEndereco.cadastrarEndereco(enderecoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping("/pegar/endereco")
    public ResponseEntity<EnderecoResponseDTO> pegarEndereco(@RequestParam(value = "id") Long id){
        EnderecoResponseDTO resposta = selecionarEndereco.selecionarDocumento(id);
        return new  ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PutMapping("/atualizar/endereco")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(@RequestParam(value = "id") Long id, @RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO){
        EnderecoResponseDTO resposta = alterarEndereco.alterarEndereco(id, enderecoRequestDTO);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/endereco")
    public ResponseEntity<Void> excluirEndereco(@RequestParam(value = "id") Long id){
        excluirEndereco.excluirEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
