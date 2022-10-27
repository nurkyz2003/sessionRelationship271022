package peaksoft.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private int age;
    private String phoneNumber;

    @ManyToMany(cascade = {DETACH,REFRESH,MERGE},fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();

    public Student(String name, String lastName, String email, int age, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courses=" + courses +
                '}';
    }
}
