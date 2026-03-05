package com.exemplo.cliente.controller;

import com.exemplo.cliente.model.Cliente;
import com.exemplo.cliente.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return repository.salvar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente alterar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return repository.atualizar(id, cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return repository.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente pesquisar(@PathVariable Long id) {
        return repository.buscarPorId(id);
    }

}