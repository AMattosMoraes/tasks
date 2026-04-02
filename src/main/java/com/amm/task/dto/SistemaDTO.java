package com.amm.task.dto;

import com.amm.task.entities.Sistema;

import java.util.Objects;

public class SistemaDTO {

    private Long id;
    private String nome;

    public SistemaDTO(){
    }

    public SistemaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public SistemaDTO(Sistema sistema){
        this.id = sistema.getId();;
        this.nome = sistema.getNome();;
    }

    public SistemaDTO fromEntity(Sistema sistema){
        return new SistemaDTO(
                sistema.getId(),
                sistema.getNome()
        );
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SistemaDTO that = (SistemaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "SistemaDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
