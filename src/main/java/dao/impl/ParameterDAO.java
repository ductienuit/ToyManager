/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.common.BasicDAO;
import dto.Parameter;

/**
 *
 * @author CMQ
 */
public class ParameterDAO extends BasicDAO<Parameter> {
    public ParameterDAO() {
        super(Parameter.class);
    }

    public Parameter getFirstParameter() {
        return this.findEntityById(1L);
    }
}
