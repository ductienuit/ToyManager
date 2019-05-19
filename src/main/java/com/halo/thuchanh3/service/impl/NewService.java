/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.service.impl;

import com.halo.thuchanh3.dao.INewDAO;
import com.halo.thuchanh3.model.NewsModel;
import com.halo.thuchanh3.service.INewService;
import java.sql.Timestamp;
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
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setCreatedBy("");
        Long id = newsDao.save(newsModel);
        System.out.print(id);
        return newsDao.findOne(id);
    }

    @Override
    public NewsModel update(NewsModel updateNews) {
        NewsModel oldNews = newsDao.findOne(updateNews.getId());
        updateNews.setCreatedDate(oldNews.getCreatedDate());
        updateNews.setCreatedBy(oldNews.getCreatedBy());
        updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNews.setModifiedBy("");
        newsDao.update(updateNews);
        return newsDao.findOne(updateNews.getId());
    }

    @Override
    public void delete(long[] ids) {
        for (long i : ids) {
            newsDao.delete(i);
        }
    }

    @Override
    public List<NewsModel> findAll(Integer offset, Integer limit, String sortName, String sortBy) {
        return newsDao.findAll(offset, limit, sortName, sortBy);
    }

    @Override
    public int getTotalItem() {
        return newsDao.getTotalItem();
    }
}
