/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.IntegerValidator;

/**
 *
 * @author CMQ
 */
public class OrderDetailQuantityValidator extends IntegerValidator {

    public OrderDetailQuantityValidator() {
        super("Số lượng", 0, Integer.MAX_VALUE);
    }
}
