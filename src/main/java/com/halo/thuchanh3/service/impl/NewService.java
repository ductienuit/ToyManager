/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.service.impl;

import com.halo.thuchanh3.dao.INewDAO;
import com.halo.thuchanh3.model.NewsModel;
import com.halo.thuchanh3.service.INewService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author DucTien
 */
public class NewService implements INewService {

    @Inject
    private INewDAO news;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return news.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        Long id = news.save(newsModel);
        System.out.print(id);
        return null;
    }

}
