/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import dto.common.IDTO;

/**
 *
 * @author CMQ
 * @param <T>
 */
public abstract class BaseEntityValidator<T extends IDTO> extends BaseObjectValidator<T> {

    public BaseEntityValidator(String displayName, Class<T> type) {
        super(displayName, type);
    }

    public BaseEntityValidator(Class<T> type) {
        super(type);
    }

    public abstract ValidationPairs GetValidators(T entity);

    @Override
    public ValidationResult convert(Object convertingValue, ObjectWrapper<T> convertedValue) {
        if (getType().isInstance(convertingValue)) {
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

        // If ID is empty, it's not an object so we can skip validating
        if (value.getId() == null) {
            return result;
        }

        return GetValidators(value).getValidationResult();
    }
}
