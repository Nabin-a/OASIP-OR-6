package sit.int221.oasip.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoleValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
    String message() default "This role does not match";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    Class<? extends Enum<?>> enumClass();
}
