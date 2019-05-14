/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.dao.impl;

import com.halo.thuchanh3.dao.INewDAO;
import com.halo.thuchanh3.model.CategoryModel;
import com.halo.thuchanh3.model.NewsModel;
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
public class NewDAO implements INewDAO {

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
    public List<NewsModel> findByCategoryId(Long categoryId) {
        List<NewsModel> results = new ArrayList<>();
        String sqlQuery = "select * from news where categoryid = ?";
        //open connection
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(sqlQuery);
                statement.setLong(1, categoryId);
                rs = statement.executeQuery();
                while (rs.next()) {
                    NewsModel news = new NewsModel();
                    news.setId(rs.getLong("id"));
                    news.setTitle(rs.getString("title"));
                    news.setCategoryId(rs.getLong("categoryid"));
                    results.add(news);
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
        return results;
    }

}
