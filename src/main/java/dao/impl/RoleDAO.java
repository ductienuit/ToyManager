/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.common.BasicDAO;
import dto.Role;

/**
 * @author CMQ
 */
public class RoleDAO extends BasicDAO<Role> {
    public RoleDAO() {
        super(Role.class);
    }
}
