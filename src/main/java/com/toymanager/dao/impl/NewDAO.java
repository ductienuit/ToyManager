/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.dao.impl;

import com.toymanager.dao.INewDAO;
import com.toymanager.mapper.NewMapper;
import com.toymanager.model.NewsModel;
import com.toymanager.paging.Pageble;

import java.util.ArrayList;
import java.util.List;

/**
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
        //String sql = "INSERT INTO news(title, content, categoryid) VALUES(?, ?, ?)";
        StringBuilder sql = new StringBuilder("INSERT INTO news(title, content,");
        sql.append("thumbnail,shortdecriptions, categoryid, createddate, createdby)");
        sql.append(" VALUES(?,?, ?, ?,?,?,?)");
        return this.insert(sql.toString(),
                newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(),
                newsModel.getShortDescriptions(), newsModel.getCategoryId(), newsModel.getCreatedDate(),
                newsModel.getCreatedBy());
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

    @Override
    public void delete(long id) {
        String sql = "delete from news where id = ? ";
        this.update(sql, id);
    }

    @Override
    public List<NewsModel> findAll(Pageble page) {
        //String sqlQuery = "select * from news limit ?,?";
        StringBuilder sqlQuery = new StringBuilder("select * from news");
        if (page.getSort() != null) {
            sqlQuery.append(" order by ").append(page.getSort().getSortName()).append(" ").append(page.getSort().getSortBy()).append("");
        }
        if (page.getOffset() != null && page.getLimit() != null) {
            sqlQuery.append(" limit ").append(page.getOffset()).append(",").append(page.getLimit());
        }
        //open connection
        return this.query(sqlQuery.toString(), new NewMapper());
    }

    @Override
    public int getTotalItem() {
        String sqlQuery = "select count(*) from news";
        //open connection
        return this.count(sqlQuery);
    }
}
