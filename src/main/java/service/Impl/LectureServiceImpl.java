package service.Impl;

import dto.LectureDto;
import dto.LectureSubjectDto;
import entity.Lecture;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.LectureRepository;
import repository.LecturerRepository;
import service.LectureService;
import service.LectureSubjectService;
import service.LecturerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public List<LectureDto> getAll() {
        List<LectureDto> lectureDtoList = new ArrayList<>();
        lectureRepository.findAll().forEach(lecture -> {
            LectureDto lectureDto = new LectureDto();
            entityToDto(lecture, lectureDto);
            lectureDtoList.add(lectureDto);
        });
        return lectureDtoList;
    }

    @Override
    public Optional<LectureDto> getByID(Integer id) {
        return Optional.empty();
    }

    @Override
    public LectureDto add(LectureDto data) {
        return null;
    }

    @Override
    public void delete(LectureDto data) {

    }

    @Override
    public LectureDto update(LectureDto data) {
        return null;
    }

    protected void entityToDto(Lecture lecture, LectureDto lectureDto) {

        lectureDto.setId(lecture.getId());
        lectureDto.setLectureName(lecture.getLectureName());

    }
}
