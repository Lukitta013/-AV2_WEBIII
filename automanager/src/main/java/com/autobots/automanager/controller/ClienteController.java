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

import java.util.List;

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

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
    ClienteResponseDTO resposta = cadastraCliente.criarCliente(clienteRequestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> pegarCliente(@PathVariable Long id) {
        ClienteResponseDTO resposta = selecionarCliente.selecionarCliente(id);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes() {
        List<ClienteResponseDTO> resposta = selecionarCliente.listarClientes();
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteRequestDTO clienteRequestDTO){
        ClienteResponseDTO resposta = alterarCliente.alterarCliente(id, clienteRequestDTO);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id){
        excluirCliente.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
}
