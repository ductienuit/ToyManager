/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

/**
 *
 * @author CMQ
 */
public class ValidationPair {

    private final IValidator validator;
    private final Object object;

    public ValidationPair(IValidator validator, Object object) {
        this.validator = validator;
        this.object = object;
    }

    /**
     * Get the value of validator
     *
     * @return the value of validator
     */
    public IValidator getValidator() {
        return validator;
    }

    /**
     * Get the value of object
     *
     * @return the value of object
     */
    public Object getObject() {
        return object;
    }

    public ValidationResult getValidationResult() {
        return getValidator().validateObject(getObject());
    }

}
