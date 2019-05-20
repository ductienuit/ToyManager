/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.BaseObjectValidator;
import utils.ObjectWrapper;
import bus.validator.common.ValidationResult;

/**
 *
 * @author CMQ
 * @param <T>
 */
public abstract class BaseRangeValidator<T extends Comparable<T>> extends BaseObjectValidator<T> {
    private T minValue;
    private T maxValue;

    public BaseRangeValidator(String displayName,
                              T minValue,
                              T maxValue,
                              Class<T> type) {
        super(displayName,
              type);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public BaseRangeValidator(T minValue,
                              T maxValue,
                              Class<T> type) {
        super(type);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Get the value of maxValue
     *
     * @return the value of maxValue
     */
    public T getMaxValue() {
        return maxValue;
    }

    /**
     * Set the value of maxValue
     *
     * @param maxValue new value of maxValue
     */
    public void setMaxValue(T maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Get the value of minValue
     *
     * @return the value of minValue
     */
    public T getMinValue() {
        return minValue;
    }

    /**
     * Set the value of minValue
     *
     * @param minValue new value of minValue
     */
    public void setMinValue(T minValue) {
        this.minValue = minValue;
    }

    @Override
    public ValidationResult validateType(T value) {
        if (value.compareTo(getMinValue()) < 0) {
            return new ValidationResult(
                false,
                getDisplayName() + " không được nhỏ hơn " + GetValueString(
                    getMinValue()) + ".");
        }

        if (value.compareTo(getMaxValue()) > 0) {
            return new ValidationResult(
                false,
                getDisplayName() + " không được lớn hơn " + GetValueString(
                    getMaxValue()) + ".");
        }

        return ValidationResult.VALID_RESULT;
    }

    protected String GetValueString(T value) {
        return value.toString();
    }
}
