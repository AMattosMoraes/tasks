package com.amm.task.entities.enums;

public enum OrdemPrioridade {

    Baixa(1),
    Media(2),
    Alta(3);

    private int code;

    OrdemPrioridade(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrdemPrioridade valueOf(int code){
        for (OrdemPrioridade value : OrdemPrioridade.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código invalido para Prioridade");
    }
}
