/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.UserStatus;

/**
 *
 * @author CMQ
 */
public class UserStatusValidator extends BaseEntityValidator<UserStatus> {
    public UserStatusValidator() {
        super("Trạng thái người dùng",
              UserStatus.class);
    }

    @Override
    public ValidationPairs GetValidators(final UserStatus entity) {
        return new ValidationPairs() {
            {
                add(new UserStatusIdValidator(),
                    entity.getId());
                add(new UserStatusNameValidator(),
                    entity.getName());
            }
        };
    }
}
