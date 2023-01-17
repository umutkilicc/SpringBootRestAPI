package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity(name = "lectureSubject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subjectName")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;


}
