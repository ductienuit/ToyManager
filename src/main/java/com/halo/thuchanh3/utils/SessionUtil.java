/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.halo.thuchanh3.utils;

/**
 * Duy trì trạng thái đăng nhập
 *
 * @author DucTien
 */
public class SessionUtil {

    public static SessionUtil mInstance;

    SessionUtil getInstance() {
        if (mInstance != null) {
            mInstance = new SessionUtil();
        }
        return this.mInstance;
    }

    public void putValue() {

    }

    public Object getValue() {
        return null;
    }

    public void removeValue() {

    }
}
