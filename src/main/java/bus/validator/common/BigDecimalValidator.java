/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.BaseRangeValidator;
import bus.validator.common.ObjectWrapper;
import bus.validator.common.ValidationResult;
import java.math.BigDecimal;

/**
 *
 * @author CMQ
 */
public class BigDecimalValidator extends BaseRangeValidator<BigDecimal> {

    public BigDecimalValidator() {
        this(BigDecimal.valueOf(Double.MIN_VALUE), BigDecimal.valueOf(Double.MAX_VALUE));
    }

    public BigDecimalValidator(BigDecimal minValue, BigDecimal maxValue) {
        super(minValue, maxValue, BigDecimal.class);
    }

    public BigDecimalValidator(String displayName, BigDecimal minValue, BigDecimal maxValue) {
        super(displayName, minValue, maxValue, BigDecimal.class);
    }

    @Override
    public ValidationResult convert(Object convertingValue, ObjectWrapper<BigDecimal> convertedValue) {
        BigDecimal result;

        try {
            result = new BigDecimal((String) convertingValue);
        } catch (NumberFormatException e) {
            return new ValidationResult(
                    false,
                    "Sai định dạng" + System.lineSeparator() + getDisplayName() + " phải là số thực.");
        }

        return ValidationResult.VALID_RESULT;
    }

}
