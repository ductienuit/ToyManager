/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.ToyStatus;

/**
 *
 * @author CMQ
 */
public class ToyStatusValidator extends BaseEntityValidator<ToyStatus> {
    public ToyStatusValidator() {
        super("Trạng thái đồ chơi",
              ToyStatus.class);
    }

    @Override
    public ValidationPairs GetValidators(final ToyStatus entity) {
        return new ValidationPairs() {
            {
                add(new RoleIdValidator(),
                    entity.getId());
                add(new RoleNameValidator(),
                    entity.getName());
            }
        };
    }
}
