package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "studentNumber", unique = true)
    private Integer studentNumber;

    @Column(name = "studentAge", length = 2)
    private Integer studentAge;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<LectureStudent> lectureStudent;


}
