/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.IntegerValidator;

/**
 *
 * @author CMQ
 */
public class RolePriorityValidator extends IntegerValidator {
    public RolePriorityValidator() {
        super("Mức quyền",
              0,
              Integer.MAX_VALUE);
    }
}
