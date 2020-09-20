package com.epam.dfilatov.istore.model;

import com.epam.dfilatov.istore.constants.IStoreConstants;
import com.epam.dfilatov.istore.exception.ValidationException;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 4135312468931865370L;
    private Map<Integer, ShoppingCartItem> products = new HashMap<>();
    private int totalCount;

    public void addProduct(int productId, int count) {
        validateShoppingCartSize(productId);
        ShoppingCartItem item = products.get(productId);
        if (item == null) {
            validateProductCount(count);
            item = new ShoppingCartItem(productId, count);
            products.put(productId, item);
        } else {
            validateProductCount(count + item.getCount());
            item.setCount(item.getCount() + count);
        }
        refreshStatistics();
    }

    public void removeProduct(int productId, int count) {
        ShoppingCartItem item = products.get(productId);
        if (item != null) {
            if (item.getCount() > count) {
                item.setCount(item.getCount() - count);
            } else {
                products.remove(productId);
            }
            refreshStatistics();
        }
    }

    private void refreshStatistics() {
        totalCount = 0;
        for (ShoppingCartItem item : getItems()) {
            totalCount += item.getCount();
        }
    }

    public Collection<ShoppingCartItem> getItems() {
        return products.values();
    }

    private void validateShoppingCartSize(int productId) throws ValidationException {
        if (products.size() > IStoreConstants.MAX_PRODUCT_PER_SHOPPING_CART ||
                (products.size() == IStoreConstants.MAX_PRODUCT_PER_SHOPPING_CART && !products.containsKey(productId))) {
            throw new ValidationException("Limit fro Shopping cart size reached: size = " + products.size());
        }
    }

    private void validateProductCount(int count) throws ValidationException {
        if (count > IStoreConstants.MAX_PRODUCT_COUNT_PER_SHOPPING_CART) {
            throw new ValidationException("Limit for product count reached: size = " + count);
        }
    }

    public String getView() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ShoppingCartItem item : getItems()) {
            stringBuilder.append(item.getProductId())
                    .append("-&gt")
                    .append(item.getCount())
                    .append("<br>");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ShoppingCart.class.getSimpleName() + "[", "]")
                .add("products=" + products)
                .add("totalCount=" + totalCount)
                .toString();
    }
}
