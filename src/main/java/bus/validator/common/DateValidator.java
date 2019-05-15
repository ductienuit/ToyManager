/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.validator.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author CMQ
 */
public class DateValidator extends BaseRangeValidator<Date> {

    public DateValidator() {
        this(Date.from(Instant.MIN), Date.from(Instant.MAX));
    }

    public DateValidator(Date minValue, Date maxValue) {
        super(minValue, maxValue, Date.class);
    }

    public DateValidator(String displayName, Date minValue, Date maxValue) {
        super(displayName, minValue, maxValue, Date.class);
    }

    @Override
    public ValidationResult convert(Object convertingValue, ObjectWrapper<Date> convertedValue) {
        if (convertingValue instanceof String) {
            String value = (String) convertingValue;

            if (value.isEmpty()
                    || value.trim().isEmpty()) {
                return new ValidationResult(
                        false,
                        getDisplayName() + " không được trống.");
            }

            DateFormat dateFormat = DateFormat.getDateTimeInstance();

            try {
                Date date = dateFormat.parse(value);
                convertedValue.setObject(date);
                return ValidationResult.VALID_RESULT;
            } catch (ParseException e) {
                return new ValidationResult(
                        false,
                        getDisplayName() + " sai định dạng.");
            }
        }

        return new ValidationResult(
                false,
                getDisplayName() + " không đúng định dạng.");
    }

}
