/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service;

import com.toymanager.model.NewsModel;
import com.toymanager.paging.Pageble;

import java.util.List;

/**
 * @author DucTien
 */
public interface IToyService {

    List<NewsModel> findByCategoryId(Long categoryId);

    NewsModel save(NewsModel newsModel);

    public NewsModel update(NewsModel newsModel);

    public void delete(long[] ids);

    List<NewsModel> findAll(Pageble page);

    int getTotalItem();

}
