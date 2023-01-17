package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity(name = "lecture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "lectureName")
    private String lectureName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "LECTURER_FK"))
    @ToString.Exclude
    private Lecturer lecturer;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<LectureSubject> lectureSubject;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<LectureStudent> lectureStudent;

}
