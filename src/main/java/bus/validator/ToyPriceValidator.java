/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BigDecimalValidator;
import java.math.BigDecimal;

/**
 *
 * @author CMQ
 */
public class ToyPriceValidator extends BigDecimalValidator {
    public ToyPriceValidator() {
        super("Đơn giá",
              BigDecimal.ZERO,
              BigDecimal.valueOf(Double.MAX_VALUE));
    }
}
