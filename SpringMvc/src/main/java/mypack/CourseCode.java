package mypack;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// which is used to mark this custom annotation as a constraint validator.
//It links the annotation to a class that implements the validation logic (CourseCodeValidator).
@Constraint(validatedBy = CourseCodeValidator.class)
//Specifies where this annotation can be applied.
@Target({ ElementType.METHOD, ElementType.FIELD })
//Retain this annoation in tha java class file and process it at run time
@Retention(RetentionPolicy.RUNTIME)
//Indicates that this annotation should be included in the JavaDoc.
//
//Makes the annotation visible in documentation tools.
@Documented
public @interface CourseCode {

    //This is the default prefix that the value must start with ("SPR").
    String value() default "SPR";

    //This is the default error message shown when validation fails.
    String message() default "must start with SPR";

    //define default groups--for grouping validations
    Class<?>[] groups() default {};

    //define default payloads--additional details about the error messages
    Class<? extends Payload>[] payload() default {};
}
