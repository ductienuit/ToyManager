/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator;

import bus.validator.common.BaseEntityValidator;
import bus.validator.common.ValidationPairs;
import dto.OrderDetail;

/**
 *
 * @author CMQ
 */
public class OrderDetailValidator extends BaseEntityValidator<OrderDetail> {
    public OrderDetailValidator() {
        super("Chi tiết đơn hàng",
              OrderDetail.class);
    }

    @Override
    public ValidationPairs GetValidators(final OrderDetail entity) {
        return new ValidationPairs() {
            {
                add(new OrderDetailIdValidator(),
                    entity.getId());
                add(new OrderDetailQuantityValidator(),
                    entity.getQuantity());
                add(new OrderDetailTotalPriceValidator(),
                    entity.getTotalPrice());
            }
        };
    }
}
