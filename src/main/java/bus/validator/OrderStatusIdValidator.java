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
public class OrderStatusIdValidator extends BigIntegerValidator {

    public OrderStatusIdValidator() {
        super("Mã trạng thái", BigInteger.ZERO, BigInteger.valueOf(Long.MAX_VALUE));
    }
}
