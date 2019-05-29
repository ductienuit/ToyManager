/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.common.BasicDAO;
import dto.Order;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;
import utils.ObjectWrapper;

/**
 *
 * @author CMQ
 */
public class OrderDAO extends BasicDAO<Order> {
    public OrderDAO() {
        super(Order.class);
    }

    public List<Order> findOrdersByStatusId(final long statusId) {
        final ObjectWrapper<List<Order>> ordersWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(Order.class)
                .createCriteria("orderStatus")
                .add(Restrictions.eq("id",
                                     statusId));

            List result = criteria.list();
            ordersWrapper.setObject(result);
        });

        return ordersWrapper.getObject();
    }

    public List<Order> findOrdersByPaymentDateRange(final Date fromDate,
                                                    final Date toDate) {
        final ObjectWrapper<List<Order>> ordersWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(Order.class)
                .add(Restrictions.ge("paymentDate",
                                     fromDate))
                .add(Restrictions.le("paymentDate",
                                     toDate));

            List result = criteria.list();
            ordersWrapper.setObject(result);
        });

        return ordersWrapper.getObject();
    }
}
