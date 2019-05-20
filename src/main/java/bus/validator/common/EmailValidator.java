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
public class EmailValidator extends BaseObjectValidator<String> {
    public static Boolean isValidEmailFormat(String s) {
        return s.matches(
            "^([0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$");
    }

    public EmailValidator() {
        this("Email");
    }

    public EmailValidator(String displayName) {
        super(displayName,
              String.class);
    }

    @Override
    public ValidationResult convert(Object convertingValue,
                                    ObjectWrapper<String> convertedValue) {
        if (convertingValue instanceof String) {
            convertedValue.setObject((String) convertingValue);
            return ValidationResult.VALID_RESULT;
        }

        return new ValidationResult(
            false,
            getDisplayName() + " phải có kiểu chuỗi.");
    }

    @Override
    public ValidationResult validateType(String value) {
        if (!isValidEmailFormat(value)) {
            return new ValidationResult(
                false,
                "Email không hợp lệ." + System.lineSeparator()
                    + "Email phải có dạng nguoidung@tenmien.com");
        }

        return ValidationResult.VALID_RESULT;
    }
}
