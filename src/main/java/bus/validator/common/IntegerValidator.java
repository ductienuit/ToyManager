/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.BaseRangeValidator;
import utils.ObjectWrapper;
import bus.validator.common.ValidationResult;

/**
 *
 * @author CMQ
 */
public class IntegerValidator extends BaseRangeValidator<Integer> {
    public IntegerValidator() {
        this(Integer.MIN_VALUE,
             Integer.MAX_VALUE);
    }

    public IntegerValidator(Integer minValue,
                            Integer maxValue) {
        super(minValue,
              maxValue,
              Integer.class);
    }

    public IntegerValidator(String displayName,
                            Integer minValue,
                            Integer maxValue) {
        super(displayName,
              minValue,
              maxValue,
              Integer.class);
    }

    @Override
    public ValidationResult convert(Object convertingValue,
                                    ObjectWrapper<Integer> convertedValue) {
        Integer result;

        try {
            result = Integer.parseInt((String) convertingValue);
        } catch (NumberFormatException e) {
            return new ValidationResult(
                false,
                "Sai định dạng" + System.lineSeparator() + getDisplayName()
                    + " phải là số nguyên.");
        }

        convertedValue.setObject(result);
        return ValidationResult.VALID_RESULT;
    }
}
