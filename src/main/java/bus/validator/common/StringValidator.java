/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import bus.validator.common.BaseObjectValidator;
import bus.validator.common.ObjectWrapper;
import bus.validator.common.ValidationResult;

/**
 *
 * @author CMQ
 */
public class StringValidator extends BaseObjectValidator<String> {

    private Boolean emptyAllowed;
    private Boolean whiteSpaceAllowed;
    private Boolean emptyWhiteSpaceAllowed;
    private Integer characterLimit;
    private LimitComparisonType limitComparison;

    public StringValidator() {
        this(Integer.MAX_VALUE, LimitComparisonType.LessThanOrEqual, true, true, true);
    }

    public StringValidator(String displayName) {
        this(displayName, Integer.MAX_VALUE, LimitComparisonType.LessThanOrEqual, true, true, true);
    }

    public StringValidator(
            String displayName,
            Integer characterLimit,
            LimitComparisonType limitComparison,
            Boolean emptyAllowed,
            Boolean whiteSpaceAllowed,
            Boolean emptyWhiteSpaceAllowed) {
        super(displayName, String.class);
        this.emptyAllowed = emptyAllowed;
        this.whiteSpaceAllowed = whiteSpaceAllowed;
        this.emptyWhiteSpaceAllowed = emptyWhiteSpaceAllowed;
        this.characterLimit = characterLimit;
        this.limitComparison = limitComparison;
    }

    public StringValidator(
            Integer characterLimit,
            LimitComparisonType limitComparison,
            Boolean allowEmpty,
            Boolean allowWhiteSpace,
            Boolean allowEmptyWhiteSpace) {
        super(String.class);
        this.emptyAllowed = allowEmpty;
        this.whiteSpaceAllowed = allowWhiteSpace;
        this.emptyWhiteSpaceAllowed = allowEmptyWhiteSpace;
        this.characterLimit = characterLimit;
        this.limitComparison = limitComparison;
    }

    /**
     * Get the value of limitComparison
     *
     * @return the value of limitComparison
     */
    public LimitComparisonType getLimitComparison() {
        return limitComparison;
    }

    /**
     * Set the value of limitComparison
     *
     * @param limitComparison new value of limitComparison
     */
    public void setLimitComparison(LimitComparisonType limitComparison) {
        this.limitComparison = limitComparison;
    }

    /**
     * Get the value of characterLimit
     *
     * @return the value of characterLimit
     */
    public Integer getCharacterLimit() {
        return characterLimit;
    }

    /**
     * Set the value of characterLimit
     *
     * @param characterLimit new value of characterLimit
     */
    public void setCharacterLimit(Integer characterLimit) {
        this.characterLimit = characterLimit;
    }

    /**
     * Get the value of emptyWhiteSpaceAllowed
     *
     * @return the value of emptyWhiteSpaceAllowed
     */
    public Boolean isEmptyWhiteSpaceAllowed() {
        return emptyWhiteSpaceAllowed;
    }

    /**
     * Set the value of emptyWhiteSpaceAllowed
     *
     * @param emptyWhiteSpaceAllowed new value of emptyWhiteSpaceAllowed
     */
    public void setEmptyWhiteSpaceAllowed(Boolean emptyWhiteSpaceAllowed) {
        this.emptyWhiteSpaceAllowed = emptyWhiteSpaceAllowed;
    }

    /**
     * Get the value of whiteSpaceAllowed
     *
     * @return the value of whiteSpaceAllowed
     */
    public Boolean isWhiteSpaceAllowed() {
        return whiteSpaceAllowed;
    }

    /**
     * Set the value of whiteSpaceAllowed
     *
     * @param whiteSpaceAllowed new value of whiteSpaceAllowed
     */
    public void setWhiteSpaceAllowed(Boolean whiteSpaceAllowed) {
        this.whiteSpaceAllowed = whiteSpaceAllowed;
    }

    /**
     * Get the value of emptyAllowed
     *
     * @return the value of emptyAllowed
     */
    public Boolean isEmptyAllowed() {
        return emptyAllowed;
    }

    /**
     * Set the value of emptyAllowed
     *
     * @param emptyAllowed new value of emptyAllowed
     */
    public void setEmptyAllowed(Boolean emptyAllowed) {
        this.emptyAllowed = emptyAllowed;
    }

    @Override
    public ValidationResult convert(Object convertingValue, ObjectWrapper<String> convertedValue) {
        if (convertingValue instanceof String) {
            convertedValue.setObject((String) convertingValue);
            return ValidationResult.VALID_RESULT;
        }

        return new ValidationResult(
                false,
                getDisplayName() + " phải thuộc kiễu chuỗi.");
    }

    @Override
    public ValidationResult validateType(String value) {
        if (isEmptyAllowed() == false && value.isEmpty()) {
            return new ValidationResult(
                    false,
                    getDisplayName() + " không được trống.");
        }

        if (isEmptyWhiteSpaceAllowed() == false && value.trim().isEmpty()) {
            return new ValidationResult(
                    false,
                    getDisplayName() + " không được chứa toàn kí tự trống.");
        }

        if (isWhiteSpaceAllowed() == false && value.indexOf(' ') >= 0) {
            return new ValidationResult(
                    false,
                    getDisplayName() + " không được chứa kí tự trống.");
        }

        switch (getLimitComparison()) {
            case LessThanOrEqual:
                if (value.length() > getCharacterLimit()) {
                    return new ValidationResult(
                            false,
                            getDisplayName() + " phải chứa tối đa " + getCharacterLimit() + " kí tự.");
                }
                break;

            case Equal:
                if (value.length() != getCharacterLimit()) {
                    return new ValidationResult(
                            false,
                            getDisplayName() + " phải chứa chính xác " + getCharacterLimit() + " kí tự.");
                }
                break;

            case MoreThanOrEqual:
                if (value.length() < getCharacterLimit()) {
                    return new ValidationResult(
                            false,
                            getDisplayName() + " phải chứa tối thiểu " + getCharacterLimit() + " kí tự.");
                }
                break;
        }

        return ValidationResult.VALID_RESULT;
    }

    public enum LimitComparisonType {
        LessThanOrEqual,
        Equal,
        MoreThanOrEqual,
    }

}
