package com.epam.dfilatov.istore.entity;

import java.util.StringJoiner;

/**
 * Implements account_role table of
 * Internet Store database.
 *
 * @author Denys Filatov
 */
public class AccountRole extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 3968221631728585885L;

    private String name;

    /**
     * @return name of the account role.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the account role.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AccountRole.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
