
package mypack;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import static org.junit.jupiter.api.Assertions.assertEquals;



//The test checks if the returned view name is "studentform". If the actual result is different, the test will fail.
public class StudentControllerTest {

    @Test
    public void testShowForm() {
        StudentController controller = new StudentController();
        String result = controller.showform(new ConcurrentModel());
        assertEquals("studentform", result);
    }
}

