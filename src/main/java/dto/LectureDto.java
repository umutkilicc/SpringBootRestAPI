package dto;

import entity.LectureStudent;
import entity.LectureSubject;
import entity.Lecturer;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureDto {

    private Integer id;
    private String lectureName;
    private Lecturer lecturer;
    private Set<LectureSubject> lectureSubject;
    private Set<LectureStudent> lectureStudent;
}
