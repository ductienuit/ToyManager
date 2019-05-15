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
public class ToyImageURIValidator extends StringValidator {

    public ToyImageURIValidator() {
        super("Đường dẫn hình ảnh", 256, StringValidator.LimitComparisonType.LessThanOrEqual, false, false, false);
    }
}
