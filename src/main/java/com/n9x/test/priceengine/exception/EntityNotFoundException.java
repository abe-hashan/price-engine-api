package com.n9x.test.priceengine.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(){
        super("Entity not found");
    }

}
