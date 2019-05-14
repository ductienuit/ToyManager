/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.dao.impl;

import com.halo.thuchanh3.dao.GenericDAO;
import com.halo.thuchanh3.mapper.RowMapper;
import com.halo.thuchanh3.model.CategoryModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DucTien
 */
public abstract class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/newservlet12month2018";
            String user = "root";
            String paswd = "Ductien1997";
            Connection con = DriverManager.getConnection(url, user, paswd);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                setParameter(statement, parameters);
                rs = statement.executeQuery();
                while (rs.next()) {
                    results.add(rowMapper.mapRow(rs));
                }
                return results;
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } finally {
                try {
                    //Close connection
                    connection.close();
                    if (statement != null) {
                        statement.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException ex) {
                    return null;
                }
            }
        }
        return null;
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        for (int i = 0; i < parameters.length; i++) {
            Object parameter = parameters[i];
            int index = i + 1;
            if (parameter instanceof Long) {
                try {
                    statement.setLong(index, (Long) parameter);
                } catch (SQLException ex) {
                    Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (parameter instanceof String) {
                try {
                    statement.setString(index, (String) parameter);
                } catch (SQLException ex) {
                    Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
