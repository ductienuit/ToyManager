/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.DateValidator;

/**
 *
 * @author CMQ
 */
public class OrderDateValidator extends DateValidator {
    public OrderDateValidator() {
        super("Ngày đặt hàng");
    }
}
