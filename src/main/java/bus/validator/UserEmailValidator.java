/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.EmailValidator;

/**
 *
 * @author CMQ
 */
public class UserEmailValidator extends EmailValidator {
    public UserEmailValidator() {
        super("Email người dùng");
    }
}
