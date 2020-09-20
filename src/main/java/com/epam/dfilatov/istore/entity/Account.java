package com.epam.dfilatov.istore.entity;


import java.util.StringJoiner;

/**
 * Implements account table from
 * Internet Store database.
 *
 * @author Denys Filatov
 */
public class Account extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -7971644994518366728L;

    private String name;
    private String password;
    private String role;

    /**
     * @return account owner's name;
     */
    public String getName() {
        return name;
    }


    /**
     * Set name for account owner
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return account owner's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password for account owner.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return account owner's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set role for account owner.
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("password='" + password + "'")
                .add("role='" + role + "'")
                .toString();
    }
}
