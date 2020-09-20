package com.epam.dfilatov.istore.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class ShoppingCartItem implements Serializable {

    private static final long serialVersionUID = -2922276895796077732L;
    private int productId;
    private int count;

    public ShoppingCartItem() {
        super();
    }

    public ShoppingCartItem(int productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ShoppingCartItem.class.getSimpleName() + "[", "]")
                .add("productId=" + productId)
                .add("count=" + count)
                .toString();
    }
}
