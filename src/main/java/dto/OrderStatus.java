/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.common.IDTO;
import dto.common.IName;

/**
 *
 * @author CMQ
 */
public class OrderStatus implements IDTO, IName {

    public static OrderStatus PENDING = new OrderStatus(0, "Đang chờ");
    public static OrderStatus SHIPPING = new OrderStatus(1, "Đang giao");
    public static OrderStatus SHIPPED = new OrderStatus(2, "Đã giao");
    public static OrderStatus CANCELLED = new OrderStatus(3, "Đã hủy");

    private Integer id;
    private String name;

    public OrderStatus(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
