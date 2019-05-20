/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import utils.ObjectWrapper;
import dto.common.IDTO;

/**
 *
 * @author CMQ
 * @param <T>
 */
public abstract class BaseEntityValidator<T extends IDTO> extends BaseObjectValidator<T> {
    public BaseEntityValidator(String displayName,
                               Class<T> type) {
        super(displayName,
              type);
    }

    public BaseEntityValidator(Class<T> type) {
        super(type);
    }

    public abstract ValidationPairs GetValidators(final T entity);

    @Override
    public ValidationResult convert(Object convertingValue,
                                    ObjectWrapper<T> convertedValue) {
        if (getType()
            .isInstance(convertingValue)) {
            convertedValue.setObject((T) convertingValue);
            return ValidationResult.VALID_RESULT;
        }

        return new ValidationResult(
            false,
            getDisplayName() + " không đúng kiểu dữ liệu.");
    }

    @Override
    public ValidationResult validateType(T value) {
        ValidationResult result = ValidationResult.VALID_RESULT;

        // If ID is invalid, it's not an object so we can skip validating
        if (value.getId() < 1) {
            return result;
        }

        return GetValidators(value)
            .getValidationResult();
    }
}
