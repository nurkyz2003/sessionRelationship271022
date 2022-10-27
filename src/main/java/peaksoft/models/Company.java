package peaksoft.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(cascade = {DETACH,MERGE,REFRESH,PERSIST,REMOVE},fetch = FetchType.EAGER,mappedBy = "company")
    private List<Course> courses;

    public Company(String name, String email, List<Course> courses) {
        this.name = name;
        this.email = email;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                '}';
    }
}
