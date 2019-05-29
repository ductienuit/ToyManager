/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.common;

import dto.common.IDTO;
import java.util.List;

/**
 *
 * @author CMQ
 * @param <T>
 */
public interface IDAO<T extends IDTO> {
    Long count();

    void delete(T entity);

    void delete(Iterable<T> entities);

    List<T> findAll();

    T findEntityById(Long id);

    boolean hasAny();

    Long insert(T entity);

    List<Long> insert(Iterable<T> entities);

    void update(T entity);

    void update(Iterable<T> entities);
}
