/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service.impl;

import com.toymanager.paging.Pageble;
import com.toymanager.service.IToyService;
import com.toymanager.dao.impl.ToyDAO;
import dto.Toy;

import java.util.List;

/**
 * @author DucTien
 */
public class ToyService implements IToyService<Toy> {

//    @Inject
//    private INewDAO newsDao;

    private ToyDAO toyDAO;

    ToyService(){
        toyDAO = new ToyDAO();
    }

    @Override
    public Toy findById(Long categoryId) {
        return toyDAO.findEntityById(categoryId);
    }

    @Override
    public Toy save(Toy toyModel) {
        Long id = toyDAO.insert(toyModel);
        System.out.print(id);
        return toyDAO.findEntityById(id);
    }

    @Override
    public Toy update(Toy toyModel) {
        Toy oldToy = toyDAO.findEntityById(toyModel.getId());
        toyDAO.update(oldToy);
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
