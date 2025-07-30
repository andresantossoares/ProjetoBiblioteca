package org.example.controller;

import org.example.entities.Produto;
import org.example.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id")
    public ResponseEntity<Produto> findByid(@PathVariable Long id) {
        Produto produto = service.findByID(id);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
        Produto novo = service.Insert(produto);
        return ResponseEntity.ok().body(novo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        Produto atualizado = service.update(id, produto);
        return ResponseEntity.ok().body(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }


}
