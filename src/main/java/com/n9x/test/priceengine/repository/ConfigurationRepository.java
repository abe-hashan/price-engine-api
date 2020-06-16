package com.n9x.test.priceengine.repository;

import com.n9x.test.priceengine.model.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConfigurationRepository extends CrudRepository<Configuration, Long> {

    Optional<Configuration> findByKey(String key);

}
