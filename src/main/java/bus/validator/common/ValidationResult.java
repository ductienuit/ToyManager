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
public class ValidationResult {
    public static final ValidationResult VALID_RESULT = new ValidationResult(
        true);
    private Boolean isValid;
    private Object errorObject;
    private String message;

    public ValidationResult(Boolean isValid) {
        this.isValid = isValid;
    }

    public ValidationResult(Boolean isValid,
                            String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public ValidationResult(Boolean isValid,
                            String message,
                            Object errorObject) {
        this.isValid = isValid;
        this.message = message;
        this.errorObject = errorObject;
    }

    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the value of errorObject
     *
     * @return the value of errorObject
     */
    public Object getErrorObject() {
        return errorObject;
    }

    /**
     * Set the value of errorObject
     *
     * @param errorObject new value of errorObject
     */
    public void setErrorObject(Object errorObject) {
        this.errorObject = errorObject;
    }

    /**
     * Get the value of isValid
     *
     * @return the value of isValid
     */
    public Boolean isIsValid() {
        return isValid;
    }

    /**
     * Set the value of isValid
     *
     * @param isValid new value of isValid
     */
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}
