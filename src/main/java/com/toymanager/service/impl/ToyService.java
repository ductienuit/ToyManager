/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service.impl;

import com.toymanager.dao.impl.CategoryDAO;
import com.toymanager.dao.impl.ToyStatusDAO;
import com.toymanager.paging.Pageble;
import com.toymanager.service.IToyService;
import com.toymanager.dao.impl.ToyDAO;
import dto.Category;
import dto.Toy;
import dto.ToyStatus;

import java.util.List;

/**
 * @author DucTien
 */
public class ToyService implements IToyService<Toy> {

//    @Inject
//    private INewDAO newsDao;

    private ToyDAO toyDAO;
    private CategoryDAO categoryDAO;
    private ToyStatusDAO toyStatusDAO;

    ToyService(){
        toyDAO = new ToyDAO();
        categoryDAO = new CategoryDAO();
        toyStatusDAO = new ToyStatusDAO();
    }

    @Override
    public Toy findById(Long categoryId) {
        return toyDAO.findEntityById(categoryId);
    }

    @Override
    public Toy save(Toy toyModel) {
        ToyStatus toyStatus;

        toyStatus=toyStatusDAO.findEntityById(toyModel.getIdToyStatus());
        toyModel.setToyStatus(toyStatus);

        Category category;
        category=categoryDAO.findEntityById(toyModel.getIdCategory());
        toyModel.setCategory(category);

        Long id = toyDAO.insert(toyModel);
        System.out.print(id);
        return toyDAO.findEntityById(id);
    }

    @Override
    public Toy update(Toy toyModel) {
        ToyStatus toyStatus;

        toyStatus=toyStatusDAO.findEntityById(toyModel.getIdToyStatus());
        toyModel.setToyStatus(toyStatus);

        Category category;
        category=categoryDAO.findEntityById(toyModel.getIdCategory());
        toyModel.setCategory(category);

        toyDAO.update(toyModel);
        return toyDAO.findEntityById(toyModel.getId());
    }

    @Override
    public void delete(long[] ids) {
        Toy temp;
        for (long i : ids) {
            temp = toyDAO.findEntityById(i);
            toyDAO.delete(temp);
        }
    }

    @Override
    public void delete(long id) {
        Toy temp;
        temp = toyDAO.findEntityById(id);
        toyDAO.delete(temp);
    }

    @Override
    public List<Toy> findAll(Pageble page) {
        return toyDAO.findAll(page);
    }

    @Override
    public int getTotalItem() {
        return Math.toIntExact(toyDAO.count());
    }
}
