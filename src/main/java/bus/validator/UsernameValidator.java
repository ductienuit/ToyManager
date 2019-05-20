/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.StringValidator;

/**
 *
 * @author CMQ
 */
public class UsernameValidator extends StringValidator {
    public UsernameValidator() {
        super("Tên người dùng",
              255,
              StringValidator.LimitComparisonType.LessThanOrEqual,
              false,
              false,
              false);
    }
}
