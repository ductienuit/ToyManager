/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.mapper;

import com.toymanager.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
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
            news.setThumbnail(rs.getString("thumbnail"));
            news.setShortDescriptions(rs.getString("shortdecriptions"));
            news.setCreatedDate(rs.getTimestamp("createddate"));
            news.setCreatedBy(rs.getString("createdby"));
            if (rs.getTimestamp("modifieddate") != null) {
                news.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if (rs.getTimestamp("modifiedby") != null) {
                news.setModifiedBy(rs.getString("modifiedby"));
            }
            return news;
        } catch (SQLException e) {
            return null;
        }
    }
}
