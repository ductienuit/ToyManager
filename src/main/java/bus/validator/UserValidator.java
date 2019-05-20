/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.User;

/**
 *
 * @author CMQ
 */
public class UserValidator extends BaseEntityValidator<User> {
    public UserValidator() {
        super("Người dùng",
              User.class);
    }

    @Override
    public ValidationPairs GetValidators(final User entity) {
        return new ValidationPairs() {
            {
                add(new UserIdValidator(),
                    entity.getId());
                add(new UsernameValidator(),
                    entity.getUsername());
                add(new UserPasswordValidator(),
                    entity.getPassword());
                add(new UserFullNameValidator(),
                    entity.getFullName());
                add(new UserEmailValidator(),
                    entity.getEmail());
                add(new UserPhoneValidator(),
                    entity.getPhoneNumber());
                add(new UserAddressValidator(),
                    entity.getAddress());
                add(new UserCreatedDateValidator(),
                    entity.getCreatedDate());
                add(new UserLastModifiedDateValidator(),
                    entity.getLastModifiedDate());
            }
        };
    }
}
