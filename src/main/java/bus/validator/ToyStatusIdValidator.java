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
public class ToyStatusIdValidator extends LongValidator {
    public ToyStatusIdValidator() {
        super("Mã trạng thái đồ chơi",
              0L,
              Long.MAX_VALUE);
    }
}
