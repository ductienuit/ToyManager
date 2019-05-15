/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.common.IDTO;
import dto.common.IName;
import java.math.BigInteger;

/**
 *
 * @author CMQ
 */
public class OrderStatus implements IDTO, IName {

    // TODO Order Status enum
    private BigInteger id;
    private String name;

    public OrderStatus(BigInteger id, String name) {
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

}
