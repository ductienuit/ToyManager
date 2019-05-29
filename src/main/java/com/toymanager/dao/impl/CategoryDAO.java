/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao.impl;

import com.toymanager.dao.ICategoryDAO;
import com.toymanager.mapper.CategoryMapper;
import com.toymanager.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DucTien
 */
public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() {
        List<CategoryModel> results = new ArrayList<>();
        String sqlQuery = "select * from category";
        //open connection
        return this.query(sqlQuery, new CategoryMapper());
    }

    @Override
    public void update(String sql, Object... parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count(String sql, Object... parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
