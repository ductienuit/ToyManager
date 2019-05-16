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
public class CategoryIdValidator extends BigIntegerValidator {

    public CategoryIdValidator() {
        super("Mã thể loại", BigInteger.ZERO, BigInteger.valueOf(Long.MAX_VALUE));
    }
}
