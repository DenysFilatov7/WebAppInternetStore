package com.epam.dfilatov.istore.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.StringJoiner;

/**
 * Implements ordering table from
 * Internet Store table.
 *
 * @author Denys Filatov
 */
public class Ordering extends AbstractEntity<Long> {

    private static final long serialVersionUID = -2139405300645404379L;

    private int idAccount;
    private List<OrderItem> items;
    private Timestamp created;
    private String status;


    /**
     * @return id of account which
     * make the order.
     */
    public int getIdAccount() {
        return idAccount;
    }


    /**
     * Connect order with account
     * which make the order.
     *
     * @param idAccount
     */
    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }


    /**
     * @return list of items in this order
     */
    public List<OrderItem> getItems() {
        return items;
    }


    /**
     * Set list of items in this order
     *
     * @param items
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * @return time when the order was created
     */
    public Timestamp getCreated() {
        return created;
    }


    /**
     * Set time when the order was created.
     *
     * @param created
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * @return status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set status of the order.
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return total cost of all products in the order.
     */
    public BigDecimal getTotalCost() {
        BigDecimal cost = BigDecimal.ZERO;
        if (items != null) {
            for (OrderItem orderItem : items) {
                cost = cost.add (orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getCount())));
            }
        }
        return cost;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ordering.class.getSimpleName() + "[", "]")
                .add("idAccount=" + idAccount)
                .add("items=" + items)
                .add("created=" + created)
                .add("status='" + status + "'")
                .toString();
    }
}
