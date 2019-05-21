/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao;

import com.toymanager.model.NewsModel;
import com.toymanager.paging.Pageble;

import java.util.List;

/**
 * @author DucTien
 */
public interface INewDAO extends GenericDAO<NewsModel> {

    List<NewsModel> findByCategoryId(Long categoryId);

    Long save(NewsModel newsModel);

    public NewsModel findOne(Long id);

    public void update(NewsModel updateNews);

    public void delete(long id);

    List<NewsModel> findAll(Pageble page);

    public int getTotalItem();
}
