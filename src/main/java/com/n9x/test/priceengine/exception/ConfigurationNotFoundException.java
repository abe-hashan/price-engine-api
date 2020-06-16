package com.n9x.test.priceengine.exception;

public class ConfigurationNotFoundException extends RuntimeException{

    public ConfigurationNotFoundException(){
        super("Configuration not found");
    }

}
