package mypack;

import javax.validation.constraints.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;


public class Student {
//    @NotBlank(message = "First name is required")
//    @Size(min = 2, message = "First name must be at least 2 characters")
@NotBlank(message = "{firstName.required}")
@Size(min = 2, message = "{firstName.size}")
    private String firstName;

//    @NotBlank(message = "Last name is required")
//    @Size(min = 2, message = "Last name must be at least 2 characters")
@NotBlank(message = "{lastName.required}")
@Size(min = 2, message = "{lastName.size}")
    private String lastName;
    private String country;

//    @NotNull(message = "Range is required")
//    @Min(value=0, message = "must be greater than or equal to zero")
//    @Max(value=10, message = "must be less than or equal to zero")
    @NotNull(message = "{numberRange.required}")
    @Min(value=0, message = "{numberRange.min}")
    @Max(value=10, message = "{numberRange.max}")
    private Integer numberRange;

//    @Pattern (regexp="^[a-zA-Z0-9]{5}")
    @Pattern(regexp="^[a-zA-Z0-9]{5}", message = "{typeMismatch.student.postalCode}")
    private String postalCode;

    private String gender; // for radio buttons

    private String hobbies; // for checkboxes


//    @CourseCode(value = "SPR", message = "Course code must start with SPR")
@CourseCode(value = "SPR", message = "{courseCode.invalid}")
    private String courseCode;


    public Student(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getNumberRange() {
        return numberRange;
    }

    public void setNumberRange(Integer numberRange) {
        this.numberRange = numberRange;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
