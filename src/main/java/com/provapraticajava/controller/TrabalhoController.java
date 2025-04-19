package com.provapraticajava.controller;

import com.provapraticajava.dto.TrabalhoDTO;
import com.provapraticajava.service.TrabalhoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {
    private final TrabalhoService service;

    public TrabalhoController(TrabalhoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TrabalhoDTO> getAll() {
        return service.findAll();
    }

    @PostMapping
    public TrabalhoDTO create(@RequestBody TrabalhoDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public TrabalhoDTO update(@PathVariable Long id, @RequestBody TrabalhoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
