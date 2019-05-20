/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

/**
 *
 * @author CMQ
 * @param <T>
 */
public abstract class BaseObjectValidator<T> extends NonNullValidator {
    private Class<T> type;

    public BaseObjectValidator(String displayName,
                               Class<T> type) {
        super(displayName);
        this.type = type;
    }

    public BaseObjectValidator(Class<T> type) {
        super();
        this.type = type;
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public Class<T> getType() {
        return type;
    }

    public abstract ValidationResult convert(Object convertingValue,
                                             ObjectWrapper<T> convertedValue);

    @Override
    public ValidationResult validateObject(Object value) {
        ValidationResult result = super.validateObject(value);

        if (result.isIsValid()) {
            if (getType()
                .isInstance(value)) {
                return validateObject((T) value);
            }

            ObjectWrapper<T> convertedValue = new ObjectWrapper<>();
            result = convert(value,
                             convertedValue);

            if (convertedValue.getObject() != null) {
                return result.isIsValid()
                       ? validateObject(convertedValue.getObject())
                       : result;
            }
        }

        return result;
    }

    public abstract ValidationResult validateType(T value);
}
