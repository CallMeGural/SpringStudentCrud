package pl.studentmanagement.studentmanagement.Student;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    /*@Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student student1 = new Student(
                    "Marek",
                    "marek@student.pl",
                    LocalDate.of(2000,1,1)
            );
            Student student2 = new Student(
                    "Joanna",
                    "joanna@student.pl",
                    LocalDate.of(2000,11,13)
            );
            repository.saveAll(List.of(student1,student2));
        };
    }*/
}
