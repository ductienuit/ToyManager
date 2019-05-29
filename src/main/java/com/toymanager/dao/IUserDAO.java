/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao;

import com.toymanager.model.UserModel;

/**
 * @author DucTien
 */
public interface IUserDAO extends GenericDAO<UserModel> {

    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
