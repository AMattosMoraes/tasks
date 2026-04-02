package com.amm.task.dto;

public class ModuloDTO  {

    private Long id;
    private String descSistema;
    private String descModulo;

    public ModuloDTO(){
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
}
