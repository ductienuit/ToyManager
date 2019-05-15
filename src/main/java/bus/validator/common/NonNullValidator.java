/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.BaseValidator;
import bus.validator.common.ValidationResult;

/**
 *
 * @author CMQ
 */
public class NonNullValidator extends BaseValidator {

    public NonNullValidator() {
        super();
    }

    public NonNullValidator(String displayName) {
        super(displayName);
    }

    @Override
    public ValidationResult validateObject(Object value) {
        if (value == null) {
            return new ValidationResult(
                    false,
                    getDisplayName() + " không tồn tại."
            );
        }

        return ValidationResult.VALID_RESULT;
    }

}
