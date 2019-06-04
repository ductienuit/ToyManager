/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao.impl;

import com.toymanager.dao.common.BasicDAO;
import dto.OrderDetail;
import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;
import utils.ObjectWrapper;

/**
 * @author CMQ
 */
public class OrderDetailDAO extends BasicDAO<OrderDetail> {
    public OrderDetailDAO() {
        super(OrderDetail.class);
    }

    public List<OrderDetail> findOrderDetailsByOrderId(final long orderId) {
        final ObjectWrapper<List<OrderDetail>> ordersWrapper
                                                   = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(OrderDetail.class)
                .createCriteria("order")
                .add(Restrictions.eq("id",
                                     orderId));

            List result = criteria.list();
            ordersWrapper.setObject(result);
        });

        return ordersWrapper.getObject();
    }

    public List<OrderDetail> findOrderDetailsByOrderIds(
        final Collection<Long> orderIds) {
        final ObjectWrapper<List<OrderDetail>> ordersWrapper
                                                   = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(OrderDetail.class)
                .createCriteria("order")
                .add(Restrictions.in("id",
                                     orderIds));

            List result = criteria.list();
            ordersWrapper.setObject(result);
        });

        return ordersWrapper.getObject();
    }

    public List<OrderDetail> findOrderDetailsByToyId(long toyId) {
        final ObjectWrapper<List<OrderDetail>> ordersWrapper
                                                   = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(OrderDetail.class)
                .createCriteria("toy")
                .add(Restrictions.eq("id",
                                     toyId));

            List result = criteria.list();
            ordersWrapper.setObject(result);
        });

        return ordersWrapper.getObject();
    }
}
