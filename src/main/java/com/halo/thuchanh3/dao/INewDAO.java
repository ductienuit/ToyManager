/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.dao;

import com.halo.thuchanh3.model.NewsModel;
import java.util.List;

/**
 *
 * @author DucTien
 */
public interface INewDAO extends GenericDAO<NewsModel> {

    List<NewsModel> findByCategoryId(Long categoryId);

    Long save(NewsModel newsModel);
}
