/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service.impl;

import com.toymanager.dao.IUserDAO;
import com.toymanager.model.UserModel;
import com.toymanager.service.IUserService;

import javax.inject.Inject;

/**
 * @author DucTien
 */
public class UserService implements IUserService {

    @Inject
    private IUserDAO userDao;

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
    }
}
