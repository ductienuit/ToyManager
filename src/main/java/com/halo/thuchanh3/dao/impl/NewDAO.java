/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.dao.impl;

import com.halo.thuchanh3.dao.INewDAO;
import com.halo.thuchanh3.mapper.NewMapper;
import com.halo.thuchanh3.model.NewsModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DucTien
 */
public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        List<NewsModel> results = new ArrayList<>();
        String sqlQuery = "select * from news where categoryid = ?";
        //open connection
        return this.query(sqlQuery, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) {
        String sql = "INSERT INTO news(title, content, categoryid) VALUES(?, ?, ?)";
        return this.insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());
    }

    @Override
    public NewsModel findOne(Long id) {
        String sql = "select * from news where id = ?";
        List<NewsModel> news = query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public void update(NewsModel updateNews) {
        StringBuilder sql = new StringBuilder("UPDATE news SET title=?, thumbnail=?,");
        sql.append("shortdecriptions = ?,content = ?,categoryid = ?,");
        sql.append("createddate = ?,createdby = ?,modifieddate = ?,modifiedby = ? WHERE id = ?");
        String mysql = sql.toString();
        this.update(mysql, updateNews.getTitle(), updateNews.getThumbnail(),
                updateNews.getShortDescriptions(), updateNews.getContent(), updateNews.getCategoryId(),
                updateNews.getCreatedDate(), updateNews.getCreatedBy(),
                updateNews.getModifiedDate(), updateNews.getModifiedBy(),
                updateNews.getId());
    }
}
