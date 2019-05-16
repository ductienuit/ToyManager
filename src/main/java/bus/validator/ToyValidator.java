/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.Toy;

/**
 *
 * @author CMQ
 */
public class ToyValidator extends BaseEntityValidator<Toy> {

    public ToyValidator() {
        super("Đồ chơi", Toy.class);
    }

    @Override
    public ValidationPairs GetValidators(final Toy entity) {
        return new ValidationPairs() {
            {
                add(new ToyIdValidator(), entity.getId());
                add(new ToyNameValidator(), entity.getName());
                add(new ToyPriceValidator(), entity.getPrice());
                add(new ToyImageURIValidator(), entity.getImageURI());
                add(new ToyDescriptionValidator(), entity.getDescription());
            }
        };
    }

}
