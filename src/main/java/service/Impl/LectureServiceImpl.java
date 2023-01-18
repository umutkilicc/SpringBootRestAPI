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
    public Optional<LectureDto> getById(Integer id) {

        Optional<LectureDto> lectureDto = Optional.of(new LectureDto());
        Optional<Lecture> lecture = lectureRepository.findById(id);
        entityToDto(lecture.orElseGet(Lecture::new), lectureDto.get());
        return lectureDto;

    }

    @Override
    public LectureDto add(LectureDto lectureDto) {
        Lecture lecture = new Lecture();
        dtoToEntity(lectureDto, lecture);
        lectureRepository.save(lecture);
        entityToDto(lecture, lectureDto);
        return lectureDto;
    }

    @Override
    public void delete(LectureDto lectureDto) {
        Lecture lecture = new Lecture();
        dtoToEntity(lectureDto, lecture);
        lectureRepository.delete(lecture);
    }

    @Override
    public LectureDto update(LectureDto lectureDto) {
        Optional<LectureDto> optinalLecture = Optional.of(new LectureDto());
        Lecture lecture = new Lecture();
        dtoToEntity(optinalLecture.get(), lecture);
        entityToDto(lectureRepository.save(lecture), lectureDto);
        return lectureDto;
    }

    protected void entityToDto(Lecture lecture, LectureDto lectureDto)
    {
        lectureDto.setId(lecture.getId());
        lectureDto.setLectureName(lecture.getLectureName());
    }

    protected void dtoToEntity(LectureDto lectureDto, Lecture lecture)
    {
        lecture.setId(lectureDto.getId());
        lecture.setLectureName(lectureDto.getLectureName());
    }
}
