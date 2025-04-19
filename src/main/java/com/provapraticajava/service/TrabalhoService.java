package com.provapraticajava.service;

import com.provapraticajava.dto.TrabalhoDTO;
import com.provapraticajava.model.Trabalho;
import com.provapraticajava.repository.TrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {
    private final TrabalhoRepository repository;

    public TrabalhoService(TrabalhoRepository repository) {
        this.repository = repository;
    }

    public List<TrabalhoDTO> findAll() {
        return repository.findAll().stream().map(t -> {
            TrabalhoDTO dto = new TrabalhoDTO();
            dto.id = t.getId();
            dto.endereco = t.getEndereco();
            return dto;
        }).collect(Collectors.toList());
    }

    public TrabalhoDTO save(TrabalhoDTO dto) {
        Trabalho t = new Trabalho();
        t.setEndereco(dto.endereco);
        t = repository.save(t);
        dto.id = t.getId();
        return dto;
    }

    public TrabalhoDTO update(Long id, TrabalhoDTO dto) {
        Trabalho t = repository.findById(id).orElseThrow();
        t.setEndereco(dto.endereco);
        t = repository.save(t);
        dto.id = t.getId();
        return dto;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
