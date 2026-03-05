package com.exemplo.produto.controller;

import com.exemplo.produto.model.Produto;
import com.exemplo.produto.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return repository.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto alterar(@PathVariable Long id, @RequestBody Produto produto) {
        return repository.atualizar(id, produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto pesquisar(@PathVariable Long id) {
        return repository.buscarPorId(id);
    }

}