package com.amm.task.dto;

import com.amm.task.entities.OrdemServico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrdemServicoDTO {

    private Long id;
    private String ordemstatus;
    private String setor;
    private LocalDate dtcadastro;
    private String cliente;
    private String prioridade;
    private Integer ordem;
    private String sistema;
    private String modulo;
    private String responsavel;
    private String usuario;
    private String titulo;
    private String servico;
    private String tiposervico;
    private String analistaresp;
    private String situacao;
    private LocalDateTime dtinicio;
    private LocalDateTime hrinicio;
    private LocalDateTime dtfinal;
    private LocalDateTime hrfinal;

    public OrdemServicoDTO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdemstatus() {
        return ordemstatus;
    }

    public void setOrdemstatus(String ordemstatus) {
        this.ordemstatus = ordemstatus;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public LocalDate getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(LocalDate dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getTiposervico() {
        return tiposervico;
    }

    public void setTiposervico(String tiposervico) {
        this.tiposervico = tiposervico;
    }

    public String getAnalistaresp() {
        return analistaresp;
    }

    public void setAnalistaresp(String analistaresp) {
        this.analistaresp = analistaresp;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(LocalDateTime dtinicio) {
        this.dtinicio = dtinicio;
    }

    public LocalDateTime getHrinicio() {
        return hrinicio;
    }

    public void setHrinicio(LocalDateTime hrinicio) {
        this.hrinicio = hrinicio;
    }

    public LocalDateTime getDtfinal() {
        return dtfinal;
    }

    public void setDtfinal(LocalDateTime dtfinal) {
        this.dtfinal = dtfinal;
    }

    public LocalDateTime getHrfinal() {
        return hrfinal;
    }

    public void setHrfinal(LocalDateTime hrfinal) {
        this.hrfinal = hrfinal;
    }

}
