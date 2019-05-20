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
public class OrderStatusIdValidator extends LongValidator {
    public OrderStatusIdValidator() {
        super("Mã trạng thái",
              0L,
              Long.MAX_VALUE);
    }
}
