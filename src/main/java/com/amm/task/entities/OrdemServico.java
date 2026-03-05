package com.amm.task.entities;

import com.amm.task.entities.enums.OrdemPrioridade;
import com.amm.task.entities.enums.OrdemStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "ordemservico")
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ordemstatus;
    private String setor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd", timezone = "GMT")
    private Instant dtcadastro;
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
    private Instant dtinicio;
    private Instant hrinicio;
    private Instant dtfinal;
    private Instant hrfinal;

    public OrdemServico(){}

    public OrdemServico(Long id, String ordemstatus, String setor, Instant dtcadastro, String cliente, String prioridade,  Integer ordem
            , String sistema, String modulo, String responsavel, String usuario, String titulo, String servico, String tiposervico,
              String analistaresp, String situacao, Instant dtinicio, Instant hrinicio, Instant dtfinal, Instant hrfinal) {
        this.id = id;
        this.ordemstatus = ordemstatus;
        this.setor = setor;
        this.dtcadastro = dtcadastro;
        this.cliente = cliente;
        this.prioridade = prioridade;
        this.ordem = ordem;
        this.sistema = sistema;
        this.modulo = modulo;
        this.responsavel = responsavel;
        this.usuario = usuario;
        this.titulo = titulo;
        this.servico = servico;
        this.tiposervico = tiposervico;
        this.analistaresp = analistaresp;
        this.situacao = situacao;
        this.dtinicio = dtinicio;
        this.hrinicio = hrinicio;
        this.dtfinal = dtfinal;
        this.hrfinal = hrfinal;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Instant getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Instant dtcadastro) {
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

    public Instant getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(Instant dtinicio) {
        this.dtinicio = dtinicio;
    }

    public Instant getHrinicio() {
        return hrinicio;
    }

    public void setHrinicio(Instant hrinicio) {
        this.hrinicio = hrinicio;
    }

    public Instant getDtfinal() {
        return dtfinal;
    }

    public void setDtfinal(Instant dtfinal) {
        this.dtfinal = dtfinal;
    }

    public Instant getHrfinal() {
        return hrfinal;
    }

    public void setHrfinal(Instant hrfinal) {
        this.hrfinal = hrfinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServico that = (OrdemServico) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "id=" + id +
                ", ordemstatus='" + ordemstatus + '\'' +
                ", setor=" + setor +
                ", dtcadastro=" + dtcadastro +
                ", cliente='" + cliente + '\'' +
                ", prioridade='" + prioridade + '\'' +
                ", ordem=" + ordem +
                ", sistema='" + sistema + '\'' +
                ", modulo='" + modulo + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", usuario='" + usuario + '\'' +
                ", titulo='" + titulo + '\'' +
                ", servico='" + servico + '\'' +
                ", tiposervico='" + tiposervico + '\'' +
                ", analistaresp='" + analistaresp + '\'' +
                ", situacao='" + situacao + '\'' +
                ", dtinicio=" + dtinicio +
                ", hrinicio=" + hrinicio +
                ", dtfinal=" + dtfinal +
                ", hrfinal=" + hrfinal +
                '}';
    }
}
