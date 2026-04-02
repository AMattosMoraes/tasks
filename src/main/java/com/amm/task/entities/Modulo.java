package com.amm.task.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "modulo")
public class Modulo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sistema")
    private String descSistema;
    @Column(name = "modulo")
    private String descModulo;

    public Modulo(){
    }

    public Modulo(Long id, String descSistema, String descModulo) {
        this.id = id;
        this.descSistema = descSistema;
        this.descModulo = descModulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescSistema() {
        return descSistema;
    }

    public void setDescSistema(String descSistema) {
        this.descSistema = descSistema;
    }

    public String getDescModulo() {
        return descModulo;
    }

    public void setDescModulo(String descModulo) {
        this.descModulo = descModulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return id.equals(modulo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", descSistema='" + descSistema + '\'' +
                ", descModulo='" + descModulo + '\'' +
                '}';
    }
}
