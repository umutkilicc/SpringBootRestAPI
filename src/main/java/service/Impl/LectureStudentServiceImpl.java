package service.Impl;

import dto.LectureDto;
import dto.LectureStudentDto;
import entity.Lecture;
import entity.LectureStudent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LectureStudentRepository;
import service.LectureStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LectureStudentServiceImpl implements LectureStudentService {

    @Autowired
    private LectureStudentRepository lectureStudentRepository;


    @Override
    public List<LectureStudentDto> getAll() {
        List<LectureStudentDto> lectureStudentDtoList = new ArrayList<>();
        lectureStudentRepository.findAll().forEach(lectureStudent -> {
            LectureStudentDto lectureStudentDto = new LectureStudentDto();
            entityToDto(lectureStudent,lectureStudentDto);
            lectureStudentDtoList.add(lectureStudentDto);
        });
        return lectureStudentDtoList;
    }
    @Override
    public Optional<LectureStudentDto> getById(Integer id) {
        Optional<LectureStudentDto> lectureStudentDto = Optional.of(new LectureStudentDto());
        Optional<LectureStudent> lectureStudent = Optional.of(lectureStudentRepository.getReferenceById(id));
        entityToDto(lectureStudent.orElseGet(LectureStudent::new), lectureStudentDto.get());
        return lectureStudentDto;
    }
    @Override
    public LectureStudentDto add(LectureStudentDto lectureStudentDto) {
        LectureStudent lectureStudent = new LectureStudent();
        dtoToEntity(lectureStudentDto, lectureStudent);
        lectureStudentRepository.save(lectureStudent);
        entityToDto(lectureStudent, lectureStudentDto);
        return lectureStudentDto;
    }
    @Override
    public void delete(LectureStudentDto lectureStudentDto) {
        LectureStudent lectureStudent = new LectureStudent();
        dtoToEntity(lectureStudentDto, lectureStudent);
        lectureStudentRepository.delete(lectureStudent);
    }
    @Override
    public LectureStudentDto update(LectureStudentDto lectureStudentDto) {
        Optional<LectureStudentDto> optionalLectureStudentDto = Optional.of(new LectureStudentDto());
        LectureStudent lectureStudent = new LectureStudent();
        dtoToEntity(optionalLectureStudentDto.get(), lectureStudent);
        entityToDto(lectureStudentRepository.save(lectureStudent), lectureStudentDto);
        return lectureStudentDto;
    }
    protected void entityToDto(LectureStudent lectureStudent, LectureStudentDto lectureStudentDto)
    {
        lectureStudentDto.setId(lectureStudent.getId());
        lectureStudentDto.setNote(lectureStudent.getNote());
    }
    protected void dtoToEntity(LectureStudentDto lectureStudentDto, LectureStudent lectureStudent)
    {
        lectureStudent.setId(lectureStudentDto.getId());
        lectureStudent.setNote(lectureStudentDto.getNote());
    }
}
