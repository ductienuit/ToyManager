/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.common.BasicDAO;
import dto.Category;

/**
 * @author CMQ
 */
public class CategoryDAO extends BasicDAO<Category> {
    public CategoryDAO() {
        super(Category.class);
    }

    public void Test() {
        CategoryDAO dao = new CategoryDAO();

        // insert
        System.out.println("1. Insert");
        Category c1 = new Category();
        c1.setName("Category 1");
        c1.setCode("the-thao");
        dao.insert(c1);
        System.out.println("Success!");

        // search
        System.out.println("2. Search");
        c1.setId(1);
        Category c2 = dao.search(c1.getId());
        if (c2 != null)
            System.out.println("Category [id = " + c2.getId() + ", name = " + c2
                    .getName() + "]");
        System.out.println("Success!");

        // update
        System.out.println("3. Update");
        Category c3 = c2;
        c3.setName("Category 2");
        dao.update(c3);
        Category c4 = dao.search(c3.getId());
        System.out.println("Category [id = " + c4.getId() + ", name = " + c4
                .getName() + "]");
        System.out.println("Success!");

        // count
        Long count = dao.count();
        System.out.println("4. Count");
        System.out.println("Category has " + count + " record(s).");
        System.out.println("Success!");

        // hasany
        Boolean hasany = dao.hasAny();
        System.out.println("5. HasAny");
        System.out.println("Category has at least 1 record: " + hasany);
        System.out.println("Success!");

        // delete
        System.out.println("6. Delete");
        dao.delete(c4);
        Category c5 = dao.search(c4.getId());
        if (c5 == null) {
            System.out.println("Attempt to find Category [id = " + c4.getId()
                    + "]: null");
        }
        System.out.println("Success!");
    }
}
