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
public class UserStatusNameValidator extends StringValidator {
    public UserStatusNameValidator() {
        super("Tên trạng thái người dùng",
              255,
              StringValidator.LimitComparisonType.LessThanOrEqual,
              false,
              false,
              false);
    }
}
