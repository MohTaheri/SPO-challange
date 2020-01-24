package challenge.soniq.taheri.spo.controllers.validator;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkforceValidator implements ConstraintValidator<Workforce, Integer[]> {

    @Value("${spo.maxAllowedRooms:100}")
    private String maxAllowedRooms = "100";

    @Value("${spo.maxAllowedStructures:100}")
    private String maxAllowedStructures = "100";

    @Override
    public boolean isValid(Integer[] structuresList, ConstraintValidatorContext context) {
        for (int roomsCount : structuresList) {
            if (roomsCount <= 0 || roomsCount > Integer.parseInt(maxAllowedRooms)) {
                return false;
            }
        }
        return structuresList.length < Integer.parseInt(maxAllowedStructures);

    }
}
