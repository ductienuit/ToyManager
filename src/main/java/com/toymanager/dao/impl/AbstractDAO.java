/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao.impl;

import com.toymanager.dao.GenericDAO;
import com.toymanager.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author DucTien
 */
public abstract class AbstractDAO<T> implements GenericDAO<T> {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    public Connection getConnection() {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/newservlet12month2018";
//            String user = "root";
//            String paswd = "Ductien1997";
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String paswd = resourceBundle.getString("password");
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
            try {
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter == null) {
                    statement.setNull(index, Types.NULL);
                }

            } catch (SQLException ex) {
                Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                //setParameter(statement, parameters);
                setParameter(statement, parameters);

                statement.executeUpdate();

                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            } finally {
                try {
                    //Close connection
                    connection.close();
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet results = null;
        Long id = null;
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                //setParameter(statement, parameters);
                this.setParameter(statement, parameters);

                statement.executeUpdate();

                results = statement.getGeneratedKeys();
                if (results.next()) {
                    id = results.getLong(1);
                }
                connection.commit();
                return id;
            } catch (SQLException ex) {
                ex.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
                return null;
            } finally {
                try {
                    //Close connection
                    connection.close();
                    if (statement != null) {
                        statement.close();
                    }
                    if (results != null) {
                        results.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public int count(String sql, Object... parameters) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int count = 0;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sql);
                setParameter(statement, parameters);
                rs = statement.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1); //Lấy giá trị đầu tiên của bảng, vì câu SQL Count
                }
                return count;
            } catch (SQLException ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                return count;
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
                    return count;
                }
            }
        }
        return count;
    }
}
