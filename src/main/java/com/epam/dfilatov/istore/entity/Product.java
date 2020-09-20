package com.epam.dfilatov.istore.entity;

import java.math.BigDecimal;
import java.util.StringJoiner;

/**
 * Implements product table of
 * Internet Store database.
 *
 * @author Denys Filatov
 */
public class Product extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 9035298765332092741L;

    private String name;
    private String description;
    private String imageLink;
    private BigDecimal price;
    private String category;
    private String producer;


    /**
     * @return name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the product.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of the product.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return path where image of the product is storing.
     */
    public String getImageLink() {
        return imageLink;
    }


    /**
     * Set path where image of the product is storing.
     *
     * @param imageLink
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    /**
     * @return price of the product.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Set price of the product.
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return this product category name.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set this product category name.
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return this product producer name.
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Set this product producer name.
     *
     * @param producer
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("imageLink='" + imageLink + "'")
                .add("price=" + price)
                .add("category='" + category + "'")
                .add("producer='" + producer + "'")
                .toString();
    }
}
