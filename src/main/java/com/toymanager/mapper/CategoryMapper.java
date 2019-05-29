/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.mapper;

import com.toymanager.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author DucTien
 */
public class CategoryMapper implements RowMapper<CategoryModel> {

    @Override
    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel category = new CategoryModel();
        try {
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            category.setCode(rs.getString("code"));
        } catch (SQLException e) {
            return null;
        }
        return category;
    }

}
