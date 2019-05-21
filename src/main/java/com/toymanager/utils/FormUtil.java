/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author DucTien
 */
public class FormUtil {

    //Param http to model
    public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
        T object = null;

        try {
            object = clazz.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println(ex.toString());
        }

        return object;
    }
}
