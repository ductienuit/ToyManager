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
public interface Pageble {

    Integer getPage();

    Integer getOffset();

    Integer getLimit();

    Sorter getSort();
}
