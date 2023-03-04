package co.develhope.email1.students.services;

import org.springframework.stereotype.Service;
import co.develhope.email1.students.entities.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "Fabrizio", "Trupia", ""),
            new Student("2", "Fabrizio", "Trupia", ""),
            new Student("3", "Fabrizio", "Trupia", ""),
            new Student("4", "Fabrizio", "Trupia", "")
            );

    public Student getStudentById(String studentId) {
        Optional<Student> studentFromList = students.stream().filter(student -> student.getId().equals(studentId)).findAny();
        return studentFromList.isPresent() ? studentFromList.get() : null;
    }
}
