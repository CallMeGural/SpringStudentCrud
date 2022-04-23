package pl.studentmanagement.studentmanagement.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public void addStudent(Student s) {
        if(repository.findStudentByEmail(s.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        repository.save(s);
    }

    public void deleteStudent(Long id) {
        if(!repository.existsById(id)) {
            throw new IllegalStateException("Student does not exist");
        }
        repository.deleteById(id);
    }
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        //does student exist?
        Student student = repository.findById(id).
                orElseThrow(() -> new IllegalStateException("Student does not exist"));
        //name is not null/empty and the same
        if(name!=null && name.length()>0 && !student.getName().equals(name))
            student.setName(name);
        //email is not null/empty and the same
        if(email!=null && email.length()>0 && !student.getEmail().equals(email)) {
            //is email taken
            if(repository.findStudentByEmail(email).isPresent())
                throw new IllegalStateException("Email already taken");
            student.setEmail(email);
        }

    }
}
