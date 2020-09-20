package com.epam.dfilatov.istore.entity;

import java.util.StringJoiner;

/**
 * Implements order_item table of
 * Internet Store database.
 *
 * @author Denys Filatov
 */
public class OrderItem extends AbstractEntity<Long> {
    private static final long serialVersionUID = 8058916908683867865L;

    private Long idOrder;
    private Product product;
    private int count;

    /**
     * @return id of the order.
     */
    public Long getIdOrder() {
        return idOrder;
    }

    /**
     * Set id of the order.
     *
     * @param idOrder
     */
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    /**
     * @return name of the product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set name of the product.
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }


    /**
     * @return count of the current product
     * in the current order.
     */
    public int getCount() {
        return count;
    }


    /**
     * Set count of the current product
     * in the current order.
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderItem.class.getSimpleName() + "[", "]")
                .add("idOrder=" + idOrder)
                .add("product=" + product)
                .add("count=" + count)
                .toString();
    }
}
