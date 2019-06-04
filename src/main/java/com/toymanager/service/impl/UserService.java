/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service.impl;

import com.toymanager.paging.Pageble;
import com.toymanager.service.IUserService;
import com.toymanager.dao.impl.UserDAO;
import dto.User;

import java.util.List;

/**
 * @author DucTien
 */
public class UserService implements IUserService<User> {

    private UserDAO userDAO;

    UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDAO.findUser(userName, password);
    }

    @Override
    public User findByUserNameAndPasswordAndStatus(String userName, String password) {
        return userDAO.findUser(userName, password);
    }

    @Override
    public User findById(Long categoryId) {
        return userDAO.findEntityById(categoryId);
    }

    @Override
    public User save(User model) {
        Long id = userDAO.insert(model);
        System.out.print(id);
        return userDAO.findEntityById(id);
    }

    @Override
    public User update(User model) {
        User oldUser = userDAO.findEntityById(model.getId());
        userDAO.update(oldUser);
        return userDAO.findEntityById(model.getId());
    }

    @Override
    public void delete(long[] ids) {
        User temp;
        for (long i : ids) {
            temp = userDAO.findEntityById(i);
            userDAO.delete(temp);
        }
    }

    @Override
    public void delete(long id) {
        User temp;
        temp = userDAO.findEntityById(id);
        userDAO.delete(temp);
    }

    @Override
    public List<User> findAll(Pageble page) {
        return userDAO.findAll(page);
    }

    @Override
    public int getTotalItem() {
        return Math.toIntExact(userDAO.count());
    }

}
