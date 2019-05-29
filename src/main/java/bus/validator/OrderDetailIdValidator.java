/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.LongValidator;

/**
 *
 * @author CMQ
 */
public class OrderDetailIdValidator extends LongValidator {
    public OrderDetailIdValidator() {
        super("Mã chi tiết đơn hàng",
              0L,
              Long.MAX_VALUE);
    }
}
