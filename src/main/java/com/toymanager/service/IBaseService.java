package com.toymanager.service;

import com.toymanager.paging.Pageble;
import dto.Toy;
import dto.common.IDTO;

import java.util.List;

public interface IBaseService<T extends IDTO> {
    T findById(Long id);

    T save(T toyModel);

    T update(T model);

    void delete(long[] ids);

    void delete(long id);

    List<T> findAll(Pageble page);

    int getTotalItem();
}
