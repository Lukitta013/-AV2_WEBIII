package com.autobots.automanager.controller;

import com.autobots.automanager.dtos.request.ClienteRequestDTO;
import com.autobots.automanager.dtos.response.ClienteResponseDTO;
import com.autobots.automanager.exceptions.RecursoNaoEncontradoException;
import com.autobots.automanager.model.entity.Cliente;
import com.autobots.automanager.repository.ClienteRepositorio;
import com.autobots.automanager.services.Cliente.AlterarCliente;
import com.autobots.automanager.services.Cliente.CadastraCliente;
import com.autobots.automanager.services.Cliente.ExcluirCLiente;
import com.autobots.automanager.services.Cliente.SelecionarCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private CadastraCliente cadastraCliente;

    @Autowired
    private SelecionarCliente selecionarCliente;

    @Autowired
    private AlterarCliente alterarCliente;

    @Autowired
    private ExcluirCLiente excluirCliente;

    @PostMapping("/cadastrar/cliente")
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
    ClienteResponseDTO resposta = cadastraCliente.criarCliente(clienteRequestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping("/pegar/cliente")
    public ResponseEntity<ClienteResponseDTO> pegarCliente(@RequestParam(value = "id") Long id){
    ClienteResponseDTO resposta = selecionarCliente.selecionarCliente(id);
    return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PutMapping("/atualizar/cliente")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@RequestParam(value = "id") Long id, @RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
        ClienteResponseDTO resposta = alterarCliente.alterarCliente(id, clienteRequestDTO);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/cliente")
    public ResponseEntity<Void> excluirCliente(@RequestParam(value = "id") Long id){
        excluirCliente.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
}
