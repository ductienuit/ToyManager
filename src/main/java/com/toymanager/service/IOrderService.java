package com.toymanager.service;

import dto.Cart;
import dto.User;
import dto.common.IDTO;

public interface IOrderService<T extends IDTO> extends IBaseService<T> {

    Boolean save(User user, Cart cart);
}
