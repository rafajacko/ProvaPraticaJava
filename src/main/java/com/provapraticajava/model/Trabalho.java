package com.provapraticajava.model;

import jakarta.persistence.*;

@Entity
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}
