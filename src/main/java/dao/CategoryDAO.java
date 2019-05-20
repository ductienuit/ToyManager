/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.common.BasicDAO;
import dto.Category;

/**
 *
 * @author CMQ
 */
public class CategoryDAO extends BasicDAO<Category> {
    public CategoryDAO() {
        super(Category.class);
    }
}
