package com.example.provapraticajava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoRepository repository;

    @GetMapping
    public List<Trabalho> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Trabalho criar(@RequestBody Trabalho trabalho) {
        return repository.save(trabalho);
    }

    @PutMapping("/{id}")
    public Trabalho atualizar(@PathVariable Long id, @RequestBody Trabalho novoTrabalho) {
        return repository.findById(id).map(t -> {
            t.setEndereco(novoTrabalho.getEndereco());
            return repository.save(t);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
