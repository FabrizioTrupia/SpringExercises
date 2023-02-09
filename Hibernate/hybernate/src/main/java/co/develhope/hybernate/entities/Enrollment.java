package co.develhope.hybernate.entities;

import javax.persistence.*;

@Entity
@Table (name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Classes classes;
    @ManyToOne
    private Student student;

    public Enrollment(){

    }

    public Enrollment(long id, Classes classes, Student student) {
        this.id = id;
        this.classes = classes;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Classes getSchoolClass() {
        return classes;
    }

    public void setSchoolClass(Classes classes) {
        this.classes = classes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}