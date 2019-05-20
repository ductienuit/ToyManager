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
public class ToyPriceValidator extends LongValidator {
    public ToyPriceValidator() {
        super("Đơn giá",
              0L,
              Long.MAX_VALUE);
    }
}
