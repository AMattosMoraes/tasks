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
    private String descsistema;
    private String descmodulo;

    public Modulo(){
    }

    public Modulo(Long id, String descsistema, String descmodulo) {
        this.id = id;
        this.descsistema = descsistema;
        this.descmodulo = descmodulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescsistema() {
        return descsistema;
    }

    public void setDescsistema(String descsistema) {
        this.descsistema = descsistema;
    }

    public String getDescmodulo() {
        return descmodulo;
    }

    public void setDescmodulo(String descmodulo) {
        this.descmodulo = descmodulo;
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
                ", descsistema='" + descsistema + '\'' +
                ", descmodulo='" + descmodulo + '\'' +
                '}';
    }
}
