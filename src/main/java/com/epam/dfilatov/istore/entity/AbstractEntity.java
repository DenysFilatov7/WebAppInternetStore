package com.epam.dfilatov.istore.entity;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * A class provides a base class for
 * entities of Internet Store app.
 *
 * @param <T> Entity id's data type.
 * @author Denys Filatov
 */
public class AbstractEntity<T> implements Serializable {
    private static final long serialVersionUID = 7399011579924342233L;

    T id;


    /**
     * Gets the id of this Entity
     *
     * @return this Entity id
     */
    public T getId() {
        return id;
    }

    /**
     * Changes the id of this Entity.
     *
     * @param id This entity new id.
     */
    public void setId(T id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
                .add("id=" + id)
                .toString();
    }
}
