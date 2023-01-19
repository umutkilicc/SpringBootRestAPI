package repository;

import entity.LectureStudent;
import entity.LectureSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureSubjectRepository extends JpaRepository<LectureSubject, Integer> {
}
