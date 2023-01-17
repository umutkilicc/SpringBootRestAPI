package dto;

import entity.Lecture;
import entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Check(constraints = "NOTE < 101")
public class LectureStudentDto {

    private Integer id;
    private Integer note;
    private Lecture lecture;
    private Student student;
}
