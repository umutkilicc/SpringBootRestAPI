package repository;

import entity.LectureStudent;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureStudentRepository extends JpaRepository<LectureStudent, Integer> {
}
