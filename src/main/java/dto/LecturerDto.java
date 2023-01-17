package dto;

import entity.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LecturerDto {

    private Integer id;
    private String lecturerName;
    private Integer lecturerAge;
    private Set<Lecture> lectures;

}
