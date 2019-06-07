/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.service;

import dto.User;
import dto.common.IDTO;

/**
 * @author DucTien
 */
public interface IUserService<T extends IDTO> extends IBaseService<T> {

    User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    User findByUserNameAndPasswordAndStatus(String userName, String password);
    boolean hasUser(String userName);
}
