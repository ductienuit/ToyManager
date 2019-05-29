/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.LongValidator;

/**
 *
 * @author CMQ
 */
public class UserStatusIdValidator extends LongValidator {
    public UserStatusIdValidator() {
        super("Mã trạng thái người dùng",
              0L,
              Long.MAX_VALUE);
    }
}
