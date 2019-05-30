/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service.impl;

import com.toymanager.service.ICategoryService;
import dao.CategoryDAO;
import dto.Category;

import javax.inject.Inject;
import java.util.List;

/**
 * @author DucTien
 */
public class CategoryService implements ICategoryService {

    //    private ICategoryDAO categoryDao;
//
//    public CategoryService() {
//        categoryDao = new CategoryDAO();
//          .......
//    }
    //@Inject   //Thay vì khai báo như phía trên, ta xài Inject thôi đủ rồi. Depenency Injection
    private CategoryDAO categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
