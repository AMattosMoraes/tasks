package com.amm.task.dto;

import com.amm.task.entities.Cliente;

import java.util.Objects;

public class ClienteDTO {

    private Long id;
    private String cnpj;
    private String nome;
    private String uf;
    private String contato;
    private String info;
    private String ativo;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String cnpj, String nome, String uf, String contato, String info, String ativo) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.uf = uf;
        this.contato = contato;
        this.info = info;
        this.ativo = ativo;
    }

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.cnpj = cliente.getCnpj();
        this.nome = cliente.getNome();
        this.uf = cliente.getUf();
        this.contato = cliente.getContato();
        this.info = cliente.getInfo();
        this.ativo = cliente.getAtivo();
    }

    public static ClienteDTO fromEntity(Cliente cliente){
        return new ClienteDTO(
                cliente.getId(),
                cliente.getCnpj(),
                cliente.getNome(),
                cliente.getUf(),
                cliente.getContato(),
                cliente.getInfo(),
                cliente.getAtivo()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO that = (ClienteDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", uf='" + uf + '\'' +
                ", contato='" + contato + '\'' +
                ", info='" + info + '\'' +
                ", ativo='" + ativo + '\'' +
                '}';
    }
}
