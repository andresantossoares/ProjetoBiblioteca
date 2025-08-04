package org.example.controller;

import org.example.entities.Fornecedor;
import org.example.entities.Fornecedor;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping()
    public ResponseEntity<List<Fornecedor>> findAll(){
        List<Fornecedor> lista = service.findAll();
        return  ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id){
        Fornecedor Fornecedor = service.findByID(id);
        return ResponseEntity.ok().body(Fornecedor);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor fornecedor) {
        Fornecedor novo = service.Insert(fornecedor);
        return  ResponseEntity.ok().body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Fornecedor atualizado = service.update(id, fornecedor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
