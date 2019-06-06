package com.toymanager.service.impl;

import com.toymanager.dao.impl.OrderDetailDAO;
import com.toymanager.dao.impl.OrderStatusDAO;
import com.toymanager.dao.impl.UserDAO;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IOrderService;
import com.toymanager.dao.impl.OrderDAO;
import dto.*;
import org.w3c.dom.UserDataHandler;

import java.util.*;

public class OrderService implements IOrderService<Order> {
    OrderDAO orderDAO;
    OrderStatusDAO orderStatusDAO;

    OrderDetailDAO orderDetailDAO;

    OrderService() {
        orderDAO = new OrderDAO();
        orderStatusDAO =  new OrderStatusDAO();
        orderDetailDAO = new OrderDetailDAO();
    }

    @Override
    public Order findById(Long categoryId) {
        return orderDAO.findEntityById(categoryId);
    }

    @Override
    public Order save(Order model) {
        OrderStatus status = orderStatusDAO.findEntityById((long) 1);
        model.setOrderStatus(status);

        Date date = new Date(System.currentTimeMillis());
        model.setOrderDate(date);
        model.setLastModifiedDate(date);

        Long id = orderDAO.insert(model);
        System.out.print(id);
        return orderDAO.findEntityById(id);
    }

    @Override
    public Order update(Order model) {
        Order updateOrder = orderDAO.findEntityById(model.getId());

        OrderStatus status = orderStatusDAO.findEntityById(model.getIdOrderStatus());
        updateOrder.setOrderStatus(status);
        Date date = new Date(System.currentTimeMillis());
        updateOrder.setOrderDate(date);
        updateOrder.setLastModifiedDate(date);

        orderDAO.update(updateOrder);
        return orderDAO.findEntityById(model.getId());
    }

    @Override
    public void delete(long[] ids) {
        Order temp;
        for (long i : ids) {
            temp = orderDAO.findEntityById(i);
            orderDAO.delete(temp);
        }
    }

    @Override
    public void delete(long id) {
        Order temp = orderDAO.findEntityById(id);
        orderDAO.delete(temp);
    }

    @Override
    public List<Order> findAll(Pageble page) {
        return orderDAO.findAll(page);
    }

    @Override
    public int getTotalItem() {
        return Math.toIntExact(orderDAO.count());
    }

    @Override
    public Boolean save(User user, Cart cart) {
        try {
            Order order = new Order();
            UserDAO userDAO = new UserDAO();
            order.setUser(user);
            order.setTotalPrice(cart.getTotalPrice());

            Order result = this.save(order);

            for (Map.Entry<Long, Item> entry:cart.getCartItems().entrySet()){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setToy(entry.getValue().getToy());
                orderDetail.setOrder(result);
                orderDetail.setQuantity(entry.getValue().getQuantity());
                orderDetail.setTotalPrice(entry.getValue().getTotalPrice());
                orderDetailDAO.insert(orderDetail);
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }

        return true;
    }
}
