/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.common.BasicDAO;
import dto.OrderStatus;

/**
 * @author CMQ
 */
public class OrderStatusDAO extends BasicDAO<OrderStatus> {
    public OrderStatusDAO() {
        super(OrderStatus.class);
    }
}
