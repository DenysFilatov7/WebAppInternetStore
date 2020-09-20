package com.epam.dfilatov.istore.entity;

import java.util.StringJoiner;

/**
 * Implements producer table of
 * Internet Store database.
 *
 * @author Denys Filatov
 */
public class Producer extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -6296266671070356730L;

    private String name;
    private int productCount;


    /**
     * @return name of the producer.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the producer.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return this producer count of products.
     */
    public int getProductCount() {
        return productCount;
    }

    /**
     * Set this producer count of products.
     *
     * @param productCount
     */
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Producer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("productCount=" + productCount)
                .toString();
    }
}
