/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toymanager.constant;

import java.io.File;

/**
 * @author DucTien
 */
public class SystemConstant {

    public static final String USERMODEL = "USERMODEL";
    public static String MODEL = "model";
    public static String MODEL_NEW_TOYS = "newToys";
    public static String MODEL_SELLER_TOYS = "sellerToys";
    public static String MODEL_3SELLER_TOYS = "threeSellerToys";
    public static String CART = "cart";
    public static String LIST = "list";
    public static String ADMIN = "admin";
    public static String USER = "user";
    public static String UPLOAD_DIRECTORY = "template"+File.separator+"web"+File.separator+"img";
    public static final int MEMORY_THRESHOLD = 1024 * 1024;
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 5;
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 5 * 5;
}
