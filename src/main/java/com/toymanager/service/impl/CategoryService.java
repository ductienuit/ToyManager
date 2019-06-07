/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service.impl;

import bus.validator.CategoryValidator;
import bus.validator.common.ValidationResult;
import com.toymanager.paging.Pageble;
import com.toymanager.service.ICategoryService;
import com.toymanager.dao.impl.CategoryDAO;
import dto.Category;

import java.util.List;

/**
 * @author DucTien
 */
public class CategoryService implements ICategoryService<Category> {

    private CategoryDAO categoryDAO;

    CategoryService() {
        categoryDAO = new CategoryDAO();
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryDAO.findEntityById(categoryId);
    }

    @Override
    public Category save(Category model) {
        CategoryValidator categoryValidator = new CategoryValidator();
        ValidationResult result =  categoryValidator.validateType(model);
        if(result.isValid()){
            Long id = categoryDAO.insert(model);
            System.out.print(id);
            return categoryDAO.findEntityById(id);
        }
        return null;
    }

    @Override
    public Category update(Category model) {
        Category oldCategory = categoryDAO.findEntityById(model.getId());
        oldCategory.setName(model.getName());
        oldCategory.setCode(model.getCode());
        categoryDAO.update(oldCategory);
        return categoryDAO.findEntityById(model.getId());
    }

    @Override
    public void delete(long[] ids) {
        Category temp;
        for (long i : ids) {
            temp = categoryDAO.findEntityById(i);
            categoryDAO.delete(temp);
        }
    }

    @Override
    public void delete(long id) {
        Category temp = categoryDAO.findEntityById(id);
        categoryDAO.delete(temp);
    }

    @Override
    public List<Category> findAll(Pageble page) {
        return categoryDAO.findAll(page);
    }

    @Override
    public int getTotalItem() {
        return Math.toIntExact(categoryDAO.count());
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
