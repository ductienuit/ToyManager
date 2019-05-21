/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.paging;

import com.toymanager.sort.Sorter;

/**
 * @author DucTien
 */
public class PageRequest implements Pageble {

    private Integer page;
    private Integer maxPageItem;
    private Sorter sort;

    public PageRequest(Integer page, Integer maxPageItem, Sorter sort) {
        this.page = page;
        this.maxPageItem = maxPageItem;
        this.sort = sort;
    }

    public Integer getMaxPageItem() {
        return maxPageItem;
    }

    public void setMaxPageItem(Integer maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    @Override
    public Sorter getSort() {
        if (this.sort != null) {
            return sort;
        }
        return null;
    }

    @Override
    public Integer getPage() {
        return this.page;
    }

    @Override
    public Integer getOffset() {
        if (this.page != null) {
            return (this.page - 1) * this.maxPageItem;
        }
        return null;
    }

    @Override
    public Integer getLimit() {
        return this.maxPageItem;
    }

}
