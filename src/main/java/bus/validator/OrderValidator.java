/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.Order;

/**
 *
 * @author CMQ
 */
public class OrderValidator extends BaseEntityValidator<Order> {
    public OrderValidator() {
        super("Đơn hàng",
              Order.class);
    }

    @Override
    public ValidationPairs GetValidators(final Order entity) {
        return new ValidationPairs() {
            {
                add(new OrderIdValidator(),
                    entity.getId());
                add(new OrderCustomerEmailValidator(),
                    entity.getCustomerEmail());
                add(new OrderCustomerPhoneValidator(),
                    entity.getCustomerPhoneNumber());
                add(new OrderCustomerAddressValidator(),
                    entity.getCustomerAddress());
                add(new OrderCustomerNameValidator(),
                    entity.getCustomerName());
                add(new OrderDateValidator(),
                    entity.getOrderDate());
                add(new OrderPaymentDate(),
                    entity.getPaymentDate());
                add(new OrderLastModifiedDate(),
                    entity.getLastModifiedDate());
                add(new OrderTotalPriceValidator(),
                    entity.getTotalPrice());
            }
        };
    }
}
