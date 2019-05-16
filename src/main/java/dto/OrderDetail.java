/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.common.IDTO;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author CMQ
 */
public class OrderDetail implements IDTO {

    private BigInteger id;
    private BigInteger toyID;
    private BigInteger orderID;
    private Integer quantity;
    private BigDecimal totalPrice;
    private Toy toy;
    private Order order;

    public OrderDetail(BigInteger id, BigInteger toyID, BigInteger orderID, Integer quantity, BigDecimal totalPrice) {
        this.id = id;
        this.toyID = toyID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    /**
     * Get the value of totalPrice
     *
     * @return the value of totalPrice
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Set the value of totalPrice
     *
     * @param totalPrice new value of totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the value of orderID
     *
     * @return the value of orderID
     */
    public BigInteger getOrderID() {
        return orderID;
    }

    /**
     * Set the value of orderID
     *
     * @param orderID new value of orderID
     */
    public void setOrderID(BigInteger orderID) {
        this.orderID = orderID;
    }

    /**
     * Get the value of toyID
     *
     * @return the value of toyID
     */
    public BigInteger getToyID() {
        return toyID;
    }

    /**
     * Set the value of toyID
     *
     * @param toyID new value of toyID
     */
    public void setToyID(BigInteger toyID) {
        this.toyID = toyID;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    @Override
    public BigInteger getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    /**
     * Get the value of toy
     *
     * @return the value of toy
     */
    public Toy getToy() {
        return toy;
    }

    /**
     * Set the value of toy
     *
     * @param toy new value of toy
     */
    public void setToy(Toy toy) {
        this.toy = toy;
    }

    /**
     * Get the value of order
     *
     * @return the value of order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Set the value of order
     *
     * @param order new value of order
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
