package pl.sztukakodu.lazyinit;

import org.apache.commons.lang.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@OrderRequestValid
public record OrderRequest(String name, boolean invoice, String vatNumber) {
}

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = OrderRequestValidator.class)
@Documented
@interface OrderRequestValid {
    String message() default "Missing VAT number while requesting for an invoice";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class OrderRequestValidator implements ConstraintValidator<OrderRequestValid, OrderRequest> {

    @Override
    public boolean isValid(OrderRequest request, ConstraintValidatorContext constraintValidatorContext) {
        if (request.invoice() && StringUtils.isBlank(request.vatNumber())) {
            return false;
        }
        return true;
    }
}
