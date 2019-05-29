/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.common.BasicDAO;
import dto.Order;

/**
 * @author CMQ
 */
public class OrderDAO extends BasicDAO<Order> {
    public OrderDAO() {
        super(Order.class);
    }
}
