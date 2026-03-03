package com.amm.task.services.exceptions;

public class ResourcesNotFoundExceptions extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourcesNotFoundExceptions(Object id){
        super("Recurso não encontrado - Id: " + id);
    }
}
