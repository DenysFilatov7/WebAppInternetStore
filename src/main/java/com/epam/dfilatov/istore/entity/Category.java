package com.epam.dfilatov.istore.entity;

import java.util.StringJoiner;

/**
 * Implements category table from
 * Internet Store database.
 *
 * @author Denys Filatov
 */
public class Category extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 4886317805784106354L;

    private String name;
    private String url;
    private Integer productCount;

    /**
     * @return name of this category of products.
     */
    public String getName() {
        return name;
    }


    /**
     * Set name for this category of products.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return url of this category of products,
     * which will be using for correct view.
     */
    public String getUrl() {
        return url;
    }


    /**
     * Set url for this category of products.
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     * @return number of products
     * in this category in the store.
     */
    public Integer getProductCount() {
        return productCount;
    }


    /**
     * Set number of products
     * in this category in the store.
     *
     * @param productCount
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Category.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("url='" + url + "'")
                .add("productCount=" + productCount)
                .toString();
    }
}
