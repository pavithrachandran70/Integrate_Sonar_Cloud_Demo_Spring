package mypack;

//Handles HTTP requests

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;


// This tells Spring that this class is a web controller that handles HTTP requests.
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    //Maps the URL /hello to the getpage() method.
    //
    //When a user accesses http://localhost:8080/hello, this method gets called.
    @RequestMapping("/hello")
    public ModelAndView  getpage() {
        //Creates a new instance of ModelAndView.
        ModelAndView n = new ModelAndView();
        //Sets the view name to index.
        n.setViewName("index");
        //Returns the ModelAndView object to Spring,
        return n;
    }

    //controller method to show the initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworldform";
    }






    @RequestMapping("/processForm")
    public String processForm(@RequestParam("StudentName") String name, Model model) {

//        System.out.println("Received name: " + name);
        // Add the data to the model
        logger.info("Received name: {}", name);
        model.addAttribute("StudentName", name);

        // Return the view name
        return "hello";
    }

@RequestMapping("/processFormVersionTwo")
public String letsShoutDude(HttpServletRequest request, Model model) {

        //You manually get parameters:
    //Uses HttpServletRequest to manually retrieve StudentName.
    String theName = request.getParameter("StudentName");

    // Handle null or empty input safely
    if (theName == null || theName.trim().isEmpty()) {
        theName = "Guest";  // Default name if user doesn't enter anything
    }

    theName = theName.toUpperCase();

    String result = "Hello " + theName;

    //This line adds data to the model, which is then sent to the view (like a JSP page) so it can be displayed to the user.
    model.addAttribute("StudentName", theName);
    model.addAttribute("message", result); // Note: "messsage" was a typo
    return "hello";
}
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("StudentName") String theName, Model model) {

//        String theName = request.getParameter("StudentName");

        // Handle null or empty input safely
        if (theName == null || theName.trim().isEmpty()) {
            theName = "Guest";  // Default name if user doesn't enter anything
        }

        theName = theName.toUpperCase();

        String result = "Hello my friend v3 " + theName;

        model.addAttribute("StudentName", theName);
        model.addAttribute("message", result); // Note: "messsage" was a typo
        return "hello";
    }


}

