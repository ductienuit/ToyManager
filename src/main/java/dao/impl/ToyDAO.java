/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.common.BasicDAO;
import dto.Toy;
import dto.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;
import utils.ObjectWrapper;

/**
 *
 * @author CMQ
 */
public class ToyDAO extends BasicDAO<Toy> {
    public ToyDAO() {
        super(Toy.class);
    }

    public List<Toy> findToysByCategoryId(final long categoryId) {
        final ObjectWrapper<List<Toy>> toysWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(Toy.class)
                .createCriteria("category")
                .add(Restrictions.eq("id",
                                     categoryId));

            List result = criteria.list();
            toysWrapper.setObject(result);
        });

        return toysWrapper.getObject();
    }

    public List<Toy> findToysByGender(final boolean gender) {
        final ObjectWrapper<List<Toy>> toysWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(Toy.class)
                .add(Restrictions.eq("gender",
                                     gender));

            List result = criteria.list();
            toysWrapper.setObject(result);
        });

        return toysWrapper.getObject();
    }

    public List<Toy> findToysByStatusId(final long statusId) {
        final ObjectWrapper<List<Toy>> toysWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(Toy.class)
                .createCriteria("toyStatus")
                .add(Restrictions.eq("id",
                                     statusId));

            List result = criteria.list();
            toysWrapper.setObject(result);
        });

        return toysWrapper.getObject();
    }

    public List<Toy> findToysContainsName(final long name) {
        final ObjectWrapper<List<Toy>> toysWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(Toy.class)
                .add(Restrictions.like("name",
                                       "%" + name + "%"));

            List result = criteria.list();
            toysWrapper.setObject(result);
        });

        return toysWrapper.getObject();
    }

    public List<Toy> findToysByPriceRange(final long minValue,
                                          final long maxValue) {
        final ObjectWrapper<List<Toy>> toysWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                .createCriteria(Toy.class)
                .add(Restrictions.ge("price",
                                     minValue))
                .add(Restrictions.le("price",
                                     maxValue));

            List result = criteria.list();
            toysWrapper.setObject(result);
        });

        return toysWrapper.getObject();
    }
}
