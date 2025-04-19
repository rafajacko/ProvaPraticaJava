package com.provapraticajava.service;

import com.provapraticajava.dto.PessoaDTO;
import com.provapraticajava.model.Pessoa;
import com.provapraticajava.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<PessoaDTO> findAll() {
        return repository.findAll().stream().map(p -> {
            PessoaDTO dto = new PessoaDTO();
            dto.id = p.getId();
            dto.nome = p.getNome();
            dto.cpf = p.getCpf();
            return dto;
        }).collect(Collectors.toList());
    }

    public PessoaDTO save(PessoaDTO dto) {
        Pessoa p = new Pessoa();
        p.setNome(dto.nome);
        p.setCpf(dto.cpf);
        p = repository.save(p);
        dto.id = p.getId();
        return dto;
    }

    public PessoaDTO update(Long id, PessoaDTO dto) {
        Pessoa p = repository.findById(id).orElseThrow();
        p.setNome(dto.nome);
        p.setCpf(dto.cpf);
        p = repository.save(p);
        dto.id = p.getId();
        return dto;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
