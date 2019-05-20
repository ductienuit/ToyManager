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
public abstract class BaseValidator implements IValidator {
    private String displayName;

    public BaseValidator() {
        this("Giá trị");
    }

    public BaseValidator(String DisplayName) {
        this.displayName = DisplayName;
    }

    /**
     * Get the value of displayName
     *
     * @return the value of displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the value of displayName
     *
     * @param displayName new value of displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
