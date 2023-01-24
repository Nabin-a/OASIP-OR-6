package sit.int221.oasip.validators;

import org.springframework.beans.factory.annotation.Autowired;
import sit.int221.oasip.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !userRepository.existsByName(name);
    }
}
