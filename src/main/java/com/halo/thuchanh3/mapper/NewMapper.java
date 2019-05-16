/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.mapper;

import com.halo.thuchanh3.model.NewsModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DucTien
 */
public class NewMapper implements RowMapper<NewsModel> {

    @Override
    public NewsModel mapRow(ResultSet rs) {
        NewsModel news = new NewsModel();
        try {
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
        } catch (SQLException e) {
            return null;
        }
        return news;
    }
}
