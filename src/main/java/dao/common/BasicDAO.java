/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.common;

import dto.common.IDTO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import utils.HibernateUtil;
import utils.ObjectWrapper;

/**
 *
 * @author CMQ
 * @param <T>
 */
public class BasicDAO<T extends IDTO> implements IDAO<T> {
    private final Class<T> type;

    public BasicDAO(Class<T> type) {
        this.type = type;
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
    public T search(Long id) {
        final ObjectWrapper<T> entityWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            entityWrapper.setObject((T) session.get(type,
                                                    id));
        });

        return entityWrapper.getObject();
    }

    @Override
    public List<T> getAll() {
        final ObjectWrapper<List<T>> listWrapper = new ObjectWrapper<>();

        HibernateUtil.beginTransaction((session, transaction) -> {
            listWrapper.setObject(session
                .createCriteria(type)
                .list());
        });

        return listWrapper.getObject();
    }

    @Override
    public boolean hasAny() {
        return count() > 0;
    }

    @Override
    public Long insert(final T entity) {
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
}
