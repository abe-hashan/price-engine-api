package com.n9x.test.priceengine.services;

import com.n9x.test.priceengine.dto.PricePerQuantityTuple;
import com.n9x.test.priceengine.exception.EntityNotFoundException;
import com.n9x.test.priceengine.model.Product;
import com.n9x.test.priceengine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Service
public class PriceServiceImpl implements PriceService{

    @Autowired
    ConfigurationService configurationService;

    @Autowired
    ProductRepository productRepository;


    @Override
    public double getOptimizedPrice(long productId, int quantity) {
        double discountEligibilityCount = configurationService.getMultipleCartonDiscountEligibilityCount();
        double discountPercentage = configurationService.getMultipleCartonDiscountAmount();
        double singleItemIncreasePercentage = configurationService.getSingleItemIncreaseAmount();

        Product product = productRepository.findById(productId).orElseThrow(()-> new EntityNotFoundException());
        double price = calculateOptimizedPrice(
                quantity, product, singleItemIncreasePercentage, discountEligibilityCount,discountPercentage);

        return price;

    }

    @Override
    public List<PricePerQuantityTuple>  getOptimizedPriceList(long productId, int itemsCount) {
        double discountEligibilityCount = configurationService.getMultipleCartonDiscountEligibilityCount();
        double discountPercentage = configurationService.getMultipleCartonDiscountAmount();
        double singleItemIncreasePercentage = configurationService.getSingleItemIncreaseAmount();

        Product product = productRepository.findById(productId).orElseThrow(()-> new EntityNotFoundException());

        List<PricePerQuantityTuple> prices = new ArrayList<>();

        IntStream.range(1, itemsCount+ 1).forEach(quantity -> {
            double price = calculateOptimizedPrice(
                    quantity, product, singleItemIncreasePercentage, discountEligibilityCount,discountPercentage);
            prices.add(new PricePerQuantityTuple(price, quantity));
        });

        return prices;
    }

    private double calculateOptimizedPrice(
            int quantity, Product product, double singleItemIncreasePercentage,
            double discountEligibilityCount, double discountPercentage   ){
        int singleUnits = quantity % product.getCarton_size();
        double singleUnitPrice = (1.0 + singleItemIncreasePercentage/100.0)
                * product.getCarton_price() / product.getCarton_size();

        int cartons = quantity / product.getCarton_size();
        double cartonPrice = product.getCarton_price();
        if(cartons >= discountEligibilityCount){
            cartonPrice = cartonPrice + cartonPrice * discountPercentage / 100;
        }

        double price = singleUnits* singleUnitPrice + cartons* cartonPrice;
        return price;
    }
}
