package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "lecturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "lecturerName")
    private String lecturerName;

    @Column(name = "lecturerAge")
    private Integer lecturerAge;

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private Set<Lecture> lectures;

}
