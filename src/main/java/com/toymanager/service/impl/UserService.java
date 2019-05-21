/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.service.impl;

import com.halo.thuchanh3.dao.IUserDAO;
import com.halo.thuchanh3.model.UserModel;
import com.halo.thuchanh3.service.IUserService;
import javax.inject.Inject;

/**
 *
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
