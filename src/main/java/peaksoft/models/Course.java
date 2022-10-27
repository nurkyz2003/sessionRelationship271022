package peaksoft.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String localDateOfStart;
    private String localDateOfFinish;


    @ManyToOne(cascade = {DETACH,MERGE,REFRESH},fetch = FetchType.LAZY)
    private Company company;

    @ManyToMany(cascade = ALL,fetch = FetchType.EAGER,mappedBy = "courses")
    private List<Student> students;

    public Course(String name, String localDateOfStart, String localDateOfFinish, List<Student> students) {
        this.name = name;
        this.localDateOfStart = localDateOfStart;
        this.localDateOfFinish = localDateOfFinish;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", localDateOfStart='" + localDateOfStart + '\'' +
                ", localDateOfFinish='" + localDateOfFinish + '\'' +
                ", company=" + company +
                ", students=" + students +
                '}';
    }
}
