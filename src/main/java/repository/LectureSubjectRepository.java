package repository;

import entity.LectureStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureSubjectRepository extends JpaRepository<LectureStudent, Integer> {
}
