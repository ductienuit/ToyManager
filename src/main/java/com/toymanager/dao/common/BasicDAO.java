/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao.common;

import com.toymanager.paging.Pageble;
import dto.common.IDTO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import utils.HibernateUtil;
import utils.ObjectWrapper;

/**
 * @param <T>
 * @author CMQ
 */
public abstract class BasicDAO<T extends IDTO> implements IDAO<T> {
    private final Class<T> type;

    public BasicDAO(Class<T> type) {
        this.type = type;
    }

    @Override
    public Long count() {
        final ObjectWrapper<Long> countWrapper = new ObjectWrapper<>(0L);

        HibernateUtil.beginTransaction((session, transaction) -> {
            Criteria criteria = session
                    .createCriteria(type)
                    .setProjection(Projections.rowCount());

            List result = criteria.list();
            if (!result.isEmpty()) {
                countWrapper.setObject((Long) result.get(0));
            }
        });

        return countWrapper.getObject();
    }

    @Override
    public void delete(final T entity) {
        HibernateUtil.beginTransaction((session, transaction) -> {
            session.delete(entity);
            transaction.commit();
        });
    }

    @Override
    public void delete(final Iterable<T> entities) {
        HibernateUtil.beginTransaction((session, transaction) -> {
            for (T entity : entities) {
                session.delete(entity);
            }

            transaction.commit();
        });
    }

    @Override
    public List<T> findAll() {
        final ObjectWrapper<List<T>> listWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            listWrapper.setObject(session
                .createCriteria(type)
                .list());
        });

        return listWrapper.getObject();
    }

    @Override
    public T findEntityById(Long id) {
        final ObjectWrapper<T> entityWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            entityWrapper.setObject((T) session.get(type,
                                                    id));
        });

        return entityWrapper.getObject();
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public Class<T> getType() {
        return type;
    }

    @Override
    public boolean hasAny() {
        return count() > 0;
    }

    @Override
    public Long insert(T entity) {
        final ObjectWrapper<Long> idWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            idWrapper.setObject((Long) session.save(entity));
            transaction.commit();
        });

        return idWrapper.getObject();
    }

    @Override
    public List<Long> insert(final Iterable<T> entities) {
        final ArrayList<Long> ids = new ArrayList<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            for (T entity : entities) {
                ids.add((Long) session.save(entity));
            }

            transaction.commit();
        });

        return ids;
    }

    @Override
    public void update(final T entity) {
        HibernateUtil.beginTransaction((session, transaction) -> {
            session.update(entity);
            transaction.commit();
        });
    }

    @Override
    public void update(final Iterable<T> entities) {
        HibernateUtil.beginTransaction((session, transaction) -> {
            for (T entity : entities) {
                session.update(entity);
            }

            transaction.commit();
        });
    }
    @Override
    public List<T> findAll(Pageble page){
        final ObjectWrapper<List<T>> listWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            listWrapper.setObject(session
                    .createCriteria(type)
                    .setFirstResult(page.getOffset())
                    .setMaxResults(page.getLimit())
                    .addOrder(Order.desc(page.getSort().getSortName()))
                    .list());
        });

        return listWrapper.getObject();
    }
}
