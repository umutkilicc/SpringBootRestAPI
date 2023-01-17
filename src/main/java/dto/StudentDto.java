package dto;

import entity.LectureStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Long id;
    private String studentName;
    private Integer studentNumber;
    private Integer studentAge;
    private Set<LectureStudent> lectureStudent;
}
