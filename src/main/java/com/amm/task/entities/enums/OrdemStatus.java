package com.amm.task.entities.enums;

public enum OrdemStatus {

    ABERTO(1),
    ANDAMENTO(2),
    CORREÇÃO(3),
    TESTE(4),
    ROTINA(5),
    SUSPENSO(6),
    CONCLUIDO(7);

    private int code;

    OrdemStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrdemStatus valueOf(int code){
        for (OrdemStatus value : OrdemStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código invalido para Status");
    }
}
