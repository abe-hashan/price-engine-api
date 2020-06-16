package com.n9x.test.priceengine.dto;

import java.util.List;

public class PriceListResponse {

    private long productId;

    private List<PricePerQuantityTuple> prices;

    public PriceListResponse(long productId, List<PricePerQuantityTuple> prices) {
        this.productId = productId;
        this.prices = prices;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public List<PricePerQuantityTuple> getPrices() {
        return prices;
    }

    public void setPrices(List<PricePerQuantityTuple> prices) {
        this.prices = prices;
    }
}
