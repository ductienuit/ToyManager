/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.service.impl;

import com.halo.thuchanh3.dao.ICategoryDAO;
import com.halo.thuchanh3.dao.impl.CategoryDAO;
import com.halo.thuchanh3.model.CategoryModel;
import com.halo.thuchanh3.service.ICategoryService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author DucTien
 */
public class CategoryService implements ICategoryService {

//    private ICategoryDAO categoryDao;
//
//    public CategoryService() {
//        categoryDao = new CategoryDAO();
//          .......
//    }
    @Inject   //Thay vì khai báo như phía trên, ta xài Inject thôi đủ rồi. Depenency Injection
    private ICategoryDAO categoryDao;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }
}
