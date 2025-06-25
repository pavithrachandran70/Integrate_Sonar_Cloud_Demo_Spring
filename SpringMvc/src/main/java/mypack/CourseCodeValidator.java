package mypack;
import javax.validation.ConstraintValidator;
//Provides context and operations related to validation (e.g., to customize error messages).
import javax.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    //Sets up the prefix from the annotation
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value(); // SPR
    }

    @Override
    //Checks if the field value starts with that prefix
    //Parameters:
    //
    //code: The actual field value to validate.
    //
    //context: Provides context (optional use, e.g., custom messages).
    public boolean isValid(String code, ConstraintValidatorContext context) {
        if (code == null) {
            return true; // Let @NotNull handle null
        }
        //Checks if the given string starts with the specified prefix (like "SPR").
        return code.startsWith(coursePrefix);
    }
}
