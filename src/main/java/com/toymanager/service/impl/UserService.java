/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service.impl;

import com.toymanager.dao.IUserDAO;
import com.toymanager.model.UserModel;
import com.toymanager.service.IUserService;
import dao.impl.UserDAO;
import dto.User;

import javax.inject.Inject;

/**
 * @author DucTien
 */
public class UserService implements IUserService {

    @Inject
    private IUserDAO userDao;

    private UserDAO userDAO2=new UserDAO();

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
    }

    @Override
    public User findByUserNameAndPasswordAndStatus(String userName, String password) {
        return userDAO2.findUser(userName,password);
    }
}
