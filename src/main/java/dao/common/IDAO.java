/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.common;

import dto.common.IDTO;

import java.util.List;

/**
 * @param <T>
 * @author CMQ
 */
public interface IDAO<T extends IDTO> {
    Long insert(T entity);

    List<Long> insert(List<T> entities);

    void update(T entity);

    void update(Iterable<T> entities);

    void delete(T entity);

    void delete(Iterable<T> entities);

    Iterable<T> findAll();

    boolean hasAny();

    Long count();

    T search(Long id);
}
