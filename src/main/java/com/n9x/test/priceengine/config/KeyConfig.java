package com.n9x.test.priceengine.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "key")
public class KeyConfig {

    private String cartonDiscount;
    private String singleItemIncrease;

}
