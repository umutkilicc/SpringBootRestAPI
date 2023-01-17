package dto;

import entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureSubjectDto {

    private Integer id;
    private String subjectName;
    private Lecture lecture;
}
