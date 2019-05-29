/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao.impl;

import com.toymanager.dao.IUserDAO;
import com.toymanager.mapper.UserMapper;
import com.toymanager.model.UserModel;

import java.util.List;

/**
 * @author DucTien
 */
public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        StringBuilder sql = new StringBuilder("select * from user as u");
        sql.append(" inner join role as r on r.id=u.roleid");
        sql.append(" where username=? and password=? and status=?");
        List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
        return users.isEmpty() ? null : users.get(0);
    }
}
