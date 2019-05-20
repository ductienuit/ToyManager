/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.BaseRangeValidator;
import utils.ObjectWrapper;
import bus.validator.common.ValidationResult;
import java.math.BigInteger;

/**
 *
 * @author CMQ
 */
public class LongValidator extends BaseRangeValidator<Long> {
    public LongValidator() {
        this(Long.MIN_VALUE,
             Long.MAX_VALUE);
    }

    public LongValidator(Long minValue,
                         Long maxValue) {
        super(minValue,
              maxValue,
              Long.class);
    }

    public LongValidator(String displayName,
                         Long minValue,
                         Long maxValue) {
        super(displayName,
              minValue,
              maxValue,
              Long.class);
    }

    @Override
    public ValidationResult convert(Object convertingValue,
                                    ObjectWrapper<Long> convertedValue) {
        Long result;

        try {
            result = Long.valueOf((String) convertingValue);
        } catch (NumberFormatException
                 | ClassCastException e) {
            return new ValidationResult(
                false,
                "Sai định dạng" + System.lineSeparator() + getDisplayName()
                    + " phải là số nguyên.");
        }

        convertedValue.setObject(result);
        return ValidationResult.VALID_RESULT;
    }
}
