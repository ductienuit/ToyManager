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
    private INewDAO newsDao;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newsDao.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        Long id = newsDao.save(newsModel);
        System.out.print(id);
        return newsDao.findOne(id);
    }

}
