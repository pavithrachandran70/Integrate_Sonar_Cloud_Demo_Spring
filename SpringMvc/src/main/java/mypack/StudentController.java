package mypack;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedString;

@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

@InitBinder
public void initBinder(WebDataBinder dataBinder){
    StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

}




@GetMapping("/showform")
//model is used to pass data between controllers and views
    public String showform(Model themodel){

    //create a student object
    Student theStudent = new Student();


    //add student object to the model
    //name,value
    themodel.addAttribute("student",theStudent);

        return "studentform" ;
    }

//    @PostMapping("/processform")
//    public  String ProcessForm(@ModelAttribute("student") Student theStudent,Model model){
//    //log the input data
//
//
//
//        System.out.println("theStudent" + theStudent.getFirstName()  + "" + theStudent.getLastName());
//
//        model.addAttribute("student", theStudent);
//        return "studentconfirmation";
//    }
@PostMapping("/processform")
public String processForm(
        @Valid @ModelAttribute("student") Student theStudent,
        BindingResult bindingResult,
        Model model) {

//    System.out.println("BINDING RESULT:"+ bindingResult);
    logger.debug("Binding result: {}", bindingResult);
    // Check for validation errors
    if (bindingResult.hasErrors()) {
        System.out.println("Validation errors: " + bindingResult);
        return "studentform"; // go back to the form
    }

    // Log input data
//    System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
    logger.info("Submitted student: {} {}", theStudent.getFirstName(), theStudent.getLastName());
    logger.error("Validation errors: {}", bindingResult);

    model.addAttribute("student", theStudent);
    return "studentconfirmation";
}

}
