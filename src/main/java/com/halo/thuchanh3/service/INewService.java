/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.service;

import com.halo.thuchanh3.model.NewsModel;
import java.util.List;

/**
 *
 * @author DucTien
 */
public interface INewService {

    List<NewsModel> findByCategoryId(Long categoryId);

    NewsModel save(NewsModel newsModel);

    public NewsModel update(NewsModel newsModel);

    public void delete(long[] ids);

    List<NewsModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);

    int getTotalItem();

}
