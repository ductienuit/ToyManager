/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.BaseRangeValidator;
import bus.validator.common.ObjectWrapper;
import bus.validator.common.ValidationResult;
import java.math.BigInteger;

/**
 *
 * @author CMQ
 */
public class BigIntegerValidator extends BaseRangeValidator<BigInteger> {

    public BigIntegerValidator() {
        this(BigInteger.valueOf(Long.MIN_VALUE), BigInteger.valueOf(Long.MAX_VALUE));
    }

    public BigIntegerValidator(BigInteger minValue, BigInteger maxValue) {
        super(minValue, maxValue, BigInteger.class);
    }

    public BigIntegerValidator(String displayName, BigInteger minValue, BigInteger maxValue) {
        super(displayName, minValue, maxValue, BigInteger.class);
    }

    @Override
    public ValidationResult convert(Object convertingValue, ObjectWrapper<BigInteger> convertedValue) {
        BigInteger result;

        try {
            result = new BigInteger((String) convertingValue);
        } catch (NumberFormatException e) {
            return new ValidationResult(
                    false,
                    "Sai định dạng" + System.lineSeparator() + getDisplayName() + " phải là số nguyên.");
        }

        convertedValue.setObject(result);
        return ValidationResult.VALID_RESULT;
    }

}
