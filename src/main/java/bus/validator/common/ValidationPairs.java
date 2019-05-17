/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author CMQ
 */
public class ValidationPairs extends ArrayList<ValidationPair> {

    public ValidationPairs(int initialCapacity) {
        super(initialCapacity);
    }

    public ValidationPairs() {
        super();
    }

    public ValidationPairs(Collection<? extends ValidationPair> c) {
        super(c);
    }

    public boolean add(IValidator validator, Object object) {
        return this.add(new ValidationPair(validator, object));
    }

    public ValidationResult getValidationResult() {
        ValidationResult result = ValidationResult.VALID_RESULT;

        if (this.isEmpty()) {
            return result;
        }

        for (ValidationPair pair : this) {
            result = pair.getValidationResult();
            if (!result.isIsValid()) {
                return result;
            }
        }

        return result;
    }
}
