package com.n9x.test.priceengine.services;

import com.n9x.test.priceengine.model.Product;
import com.n9x.test.priceengine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
