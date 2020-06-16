package com.n9x.test.priceengine.services;

import com.n9x.test.priceengine.exception.ConfigurationNotFoundException;
import com.n9x.test.priceengine.exception.EntityNotFoundException;
import com.n9x.test.priceengine.model.Configuration;
import com.n9x.test.priceengine.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

@Service
public class ConfigurationServiceImpl implements  ConfigurationService {

    @Autowired
    ConfigurationRepository configurationRepository;

    @Value("${key.cartonDiscount}")
    private String cartonDiscountKey;

    @Value("${key.cartonDiscountEligibility}")
    private String cartonDiscountEligibilityKey;

    @Value("${key.singleItemIncrease}")
    private String singleItemIncrease;


    @Override
    public double getSingleItemIncreaseAmount() {
        Configuration configuration = configurationRepository.findByKey(singleItemIncrease).orElseThrow(
                ()-> new ConfigurationNotFoundException()
        );
        return Double.parseDouble(configuration.getValue());
    }

    @Override
    public double getMultipleCartonDiscountAmount() {
        Configuration configuration = configurationRepository.findByKey(cartonDiscountKey).orElseThrow(
                ()-> new ConfigurationNotFoundException()
        );
        return Double.parseDouble(configuration.getValue());
    }

    @Override
    public double getMultipleCartonDiscountEligibilityCount() {
        Configuration configuration = configurationRepository.findByKey(cartonDiscountEligibilityKey).orElseThrow(
                ()-> new ConfigurationNotFoundException()
        );
        return Double.parseDouble(configuration.getValue());
    }

}
