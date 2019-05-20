/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.ValidationResult;

/**
 *
 * @author CMQ
 */
public class PhoneValidator extends StringValidator {
    public PhoneValidator() {
        this("Số điện thoại");
    }

    public PhoneValidator(String displayName) {
        super(displayName,
              10,
              LimitComparisonType.Equal,
              false,
              false,
              false);
    }

    @Override
    public ValidationResult validateType(String value) {
        ValidationResult result = super.validateType(value);

        if (result.isIsValid()) {
            try {
                Integer phone = Integer.parseUnsignedInt(value);
            } catch (NumberFormatException e) {
                return new ValidationResult(
                    false,
                    getDisplayName() + " chỉ được chứa kí tự số.");
            }
        }

        return result;
    }
}
