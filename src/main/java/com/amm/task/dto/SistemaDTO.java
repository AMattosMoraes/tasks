package com.amm.task.dto;

import com.amm.task.entities.Sistema;

import java.util.Objects;

public class SistemaDTO {

    private Long id;
    private String nome;

    public SistemaDTO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
