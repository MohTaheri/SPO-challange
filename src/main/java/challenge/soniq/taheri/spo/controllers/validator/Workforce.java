package challenge.soniq.taheri.spo.controllers.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WorkforceValidator.class)
public @interface Workforce {
    String message() default "Workforce Info is not valid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
