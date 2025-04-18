package com.example.provapraticajava;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Trabalho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;

    public Trabalho() {}

    public Trabalho(String endereco) {
        this.endereco = endereco;
    }

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}
