package pl.studentmanagement.studentmanagement.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student s) {
        service.addStudent(s);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        service.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        service.updateStudent(id,name,email);
    }

}
