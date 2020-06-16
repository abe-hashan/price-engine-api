package com.n9x.test.priceengine.controller;

import com.n9x.test.priceengine.dto.PriceListResponse;
import com.n9x.test.priceengine.dto.PricePerQuantityTuple;
import com.n9x.test.priceengine.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping
    public ResponseEntity<Double> getOptimizedPrice(@RequestParam long productId, @RequestParam int quantity) {

        return new ResponseEntity<Double>(priceService.getOptimizedPrice(productId, quantity), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<PriceListResponse> getOptimizedPrices(
            @RequestParam long productId, @RequestParam int itemsCount) {

        List<PricePerQuantityTuple> priceList = priceService.getOptimizedPriceList(productId, itemsCount);
        PriceListResponse response = new PriceListResponse(productId, priceList);

        return new ResponseEntity<PriceListResponse>(response, HttpStatus.OK);
    }
}
