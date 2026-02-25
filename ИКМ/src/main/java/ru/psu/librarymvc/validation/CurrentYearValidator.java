package ru.psu.librarymvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.Year;

public class CurrentYearValidator implements ConstraintValidator<MaxCurrentYear, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) return true; // @NotNull обработает обязательность
        int currentYear = Year.now().getValue();
        return value <= currentYear;
    }
}