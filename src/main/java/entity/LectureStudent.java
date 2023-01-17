package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity(name = "lectureStudent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Check(constraints = "NOTE < 101")
public class LectureStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "note")
    private Integer note;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "LECTURE_FK"))
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "STUDENT_FK"))
    private Student student;




}
