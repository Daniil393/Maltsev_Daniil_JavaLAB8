package ru.psu.librarymvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CurrentYearValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxCurrentYear {
    String message() default "Год публикации не может быть больше текущего года";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}