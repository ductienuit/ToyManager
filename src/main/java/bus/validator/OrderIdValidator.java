/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BigIntegerValidator;
import java.math.BigInteger;

/**
 *
 * @author CMQ
 */
public class OrderIdValidator extends BigIntegerValidator {
    public OrderIdValidator() {
        super("Mã đơn hàng",
              BigInteger.ZERO,
              BigInteger.valueOf(Long.MAX_VALUE));
    }
}
