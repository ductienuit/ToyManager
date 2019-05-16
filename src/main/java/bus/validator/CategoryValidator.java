/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.Category;

/**
 *
 * @author CMQ
 */
public class CategoryValidator extends BaseEntityValidator<Category> {

    public CategoryValidator() {
        super("Thể loại", Category.class);
    }

    @Override
    public ValidationPairs GetValidators(final Category entity) {
        return new ValidationPairs() {
            {
                add(new CategoryIdValidator(), entity.getId());
                add(new CategoryNameValidator(), entity.getName());
            }
        };
    }

}
