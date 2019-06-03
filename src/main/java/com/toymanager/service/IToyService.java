/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service;

import com.toymanager.model.NewsModel;
import com.toymanager.paging.Pageble;
import dto.Toy;

import java.util.List;

/**
 * @author DucTien
 */
public interface IToyService {

    Toy findByCategoryId(Long categoryId);

    Toy save(Toy toyModel);

    Toy update(Toy toyModel);

    void delete(long[] ids);

    List<Toy> findAll(Pageble page);

    int getTotalItem();

}
