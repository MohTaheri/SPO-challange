package challenge.soniq.taheri.spo.controllers.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkforceValidator implements ConstraintValidator<Workforce, Integer[]> {


    @Override
    public boolean isValid(Integer[] structuresList, ConstraintValidatorContext context) {
        for (int roomsCount : structuresList) {
            if (roomsCount <= 0 || roomsCount > 100) {
                return false;
            }
        }
        return structuresList.length < 100;

    }
}
