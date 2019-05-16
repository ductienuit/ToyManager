/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.OrderStatus;

/**
 *
 * @author CMQ
 */
public class OrderStatusValidator extends BaseEntityValidator<OrderStatus> {

    public OrderStatusValidator() {
        super("Trạng thái đơn hàng", OrderStatus.class);
    }

    @Override
    public ValidationPairs GetValidators(final OrderStatus entity) {
        return new ValidationPairs() {
            {
                add(new OrderStatusIdValidator(), entity.getId());
                add(new OrderStatusNameValidator(), entity.getName());
            }
        };
    }

}
