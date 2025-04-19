package com.provapraticajava.controller;

import com.provapraticajava.dto.PessoaDTO;
import com.provapraticajava.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PessoaDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public PessoaDTO create(@RequestBody PessoaDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public PessoaDTO update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
