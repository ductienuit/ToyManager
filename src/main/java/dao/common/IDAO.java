/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.common;

import dto.common.IDTO;

/**
 *
 * @author CMQ
 * @param <T>
 */
public interface IDAO<T extends IDTO> {
    Long insert(T entity);

    Iterable<Long> insert(Iterable<T> entities);

    void update(T entity);

    void update(Iterable<T> entities);

    void delete(T entity);

    void delete(Iterable<T> entities);

    Iterable<T> getAll();

    boolean hasAny();

    Long count();

    T search(Long id);
}
