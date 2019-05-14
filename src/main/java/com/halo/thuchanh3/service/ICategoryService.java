/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.service;

import com.halo.thuchanh3.model.CategoryModel;
import java.util.List;

/**
 *
 * @author DucTien
 */
public interface ICategoryService {

    List<CategoryModel> findAll();
}
