/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.Role;

/**
 *
 * @author CMQ
 */
public class RoleValidator extends BaseEntityValidator<Role> {
    public RoleValidator() {
        super("Quyền",
              Role.class);
    }

    @Override
    public ValidationPairs GetValidators(final Role entity) {
        return new ValidationPairs() {
            {
                add(new RoleIdValidator(),
                    entity.getId());
                add(new RoleNameValidator(),
                    entity.getName());
                add(new RolePriorityValidator(),
                    entity.getPriority());
            }
        };
    }
}
