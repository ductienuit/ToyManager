package com.toymanager.service.impl;

import com.toymanager.paging.Pageble;
import com.toymanager.service.IOrderService;
import com.toymanager.dao.impl.OrderDAO;
import dto.Order;

import java.util.List;

public class OrderService implements IOrderService<Order> {
    OrderDAO orderDAO;

    OrderService() {
        orderDAO = new OrderDAO();
    }

    @Override
    public Order findById(Long categoryId) {
        return orderDAO.findEntityById(categoryId);
    }

    @Override
    public Order save(Order model) {
        Long id = orderDAO.insert(model);
        System.out.print(id);
        return orderDAO.findEntityById(id);
    }

    @Override
    public Order update(Order model) {
        Order oldOrder = orderDAO.findEntityById(model.getId());
        orderDAO.update(oldOrder);
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
}
