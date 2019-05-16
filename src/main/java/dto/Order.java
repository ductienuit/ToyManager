/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.common.IDTO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 *
 * @author CMQ
 */
public class Order implements IDTO {

    private BigInteger id;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;
    private String customerName;
    private Timestamp orderDate;
    private Timestamp lastModifiedDate;
    private Timestamp paymentDate;
    private BigInteger statusID;
    private BigDecimal totalPrice;
    private OrderStatus Status;

    public Order(BigInteger id, String customerEmail, String customerPhoneNumber, String customerAddress, String customerName, Timestamp orderDate, Timestamp lastModifiedDate, Timestamp paymentDate, BigInteger statusID, BigDecimal totalPrice) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.lastModifiedDate = lastModifiedDate;
        this.paymentDate = paymentDate;
        this.statusID = statusID;
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
     * Get the value of statusID
     *
     * @return the value of statusID
     */
    public BigInteger getStatusID() {
        return statusID;
    }

    /**
     * Set the value of statusID
     *
     * @param statusID new value of statusID
     */
    public void setStatusID(BigInteger statusID) {
        this.statusID = statusID;
    }

    /**
     * Get the value of paymentDate
     *
     * @return the value of paymentDate
     */
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    /**
     * Set the value of paymentDate
     *
     * @param paymentDate new value of paymentDate
     */
    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * Get the value of lastModifiedDate
     *
     * @return the value of lastModifiedDate
     */
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Set the value of lastModifiedDate
     *
     * @param lastModifiedDate new value of lastModifiedDate
     */
    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Get the value of orderDate
     *
     * @return the value of orderDate
     */
    public Timestamp getOrderDate() {
        return orderDate;
    }

    /**
     * Set the value of orderDate
     *
     * @param orderDate new value of orderDate
     */
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Get the value of customerName
     *
     * @return the value of customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set the value of customerName
     *
     * @param customerName new value of customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Get the value of customerAddress
     *
     * @return the value of customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Set the value of customerAddress
     *
     * @param customerAddress new value of customerAddress
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Get the value of customerPhoneNumber
     *
     * @return the value of customerPhoneNumber
     */
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    /**
     * Set the value of customerPhoneNumber
     *
     * @param customerPhoneNumber new value of customerPhoneNumber
     */
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    /**
     * Get the value of customerEmail
     *
     * @return the value of customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Set the value of customerEmail
     *
     * @param customerEmail new value of customerEmail
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
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
     * Get the value of Status
     *
     * @return the value of Status
     */
    public OrderStatus getStatus() {
        return Status;
    }

    /**
     * Set the value of Status
     *
     * @param Status new value of Status
     */
    public void setStatus(OrderStatus Status) {
        this.Status = Status;
    }
}
