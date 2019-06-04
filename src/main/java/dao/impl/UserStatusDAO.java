/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.common.BasicDAO;
import dto.UserStatus;

/**
 * @author CMQ
 */
public class UserStatusDAO extends BasicDAO<UserStatus> {
    public UserStatusDAO() {
        super(UserStatus.class);
    }
}
