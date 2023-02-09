package co.develhope.hybernate.entities;

import javax.persistence.*;

@Table
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firsName;
    @Column(unique = true , nullable = false)
    private String email;

    public Student(){
    }

    public Student(long id, String lastName, String firsName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firsName = firsName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}