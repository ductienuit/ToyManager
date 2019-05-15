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
public class ToyIdValidator extends BigIntegerValidator {

    public ToyIdValidator() {
        super("Mã đồ chơi", BigInteger.ZERO, BigInteger.valueOf(Long.MAX_VALUE));
    }
}
