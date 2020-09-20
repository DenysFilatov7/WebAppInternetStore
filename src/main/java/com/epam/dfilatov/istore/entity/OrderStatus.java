package com.epam.dfilatov.istore.entity;

import java.util.StringJoiner;

/**
 * Implements order_status table of
 * Internet store database.
 *
 * @author Denys Filatov.
 */
public class OrderStatus extends AbstractEntity<Integer>{

    private static final long serialVersionUID = -8453444569920454255L;

    private String name;

    /**
     * @return name of the order status.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the order status.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderStatus.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
