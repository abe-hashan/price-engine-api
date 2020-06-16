package com.n9x.test.priceengine.services;

import com.n9x.test.priceengine.dto.PricePerQuantityTuple;
import java.util.List;

public interface PriceService {
    public double getOptimizedPrice(long productId, int quantity);

    public List<PricePerQuantityTuple>  getOptimizedPriceList(long productId, int itemsCount);
}
