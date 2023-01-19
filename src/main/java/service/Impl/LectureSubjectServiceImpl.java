package service.Impl;

import dto.LectureStudentDto;
import dto.LectureSubjectDto;
import entity.LectureStudent;
import entity.LectureSubject;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LectureSubjectRepository;
import service.LectureSubjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LectureSubjectServiceImpl implements LectureSubjectService {

    @Autowired
    private final LectureSubjectRepository lectureSubjectRepository;

    public LectureSubjectServiceImpl(LectureSubjectRepository lectureSubjectRepository) {
        this.lectureSubjectRepository = lectureSubjectRepository;
    }

    @Override
    public List<LectureSubjectDto> getAll() {
        List<LectureSubjectDto> lectureSubjectDtoList = new ArrayList<>();
        lectureSubjectRepository.findAll().forEach(lectureSubject -> {
            LectureSubjectDto lectureSubjectDto = new LectureSubjectDto();
            BeanUtils.copyProperties(lectureSubject, lectureSubjectDto);
            entityToDto(lectureSubject, lectureSubjectDto);
            lectureSubjectDtoList.add(lectureSubjectDto);
        });
        return lectureSubjectDtoList;
    }

    @Override
    public Optional<LectureSubjectDto> getById(Integer id) {
        Optional<LectureSubjectDto> lectureSubjectDto = Optional.of(new LectureSubjectDto());
        Optional<LectureSubject> lectureSubject = Optional.of(lectureSubjectRepository.getReferenceById(id));
        entityToDto(lectureSubject.orElseGet(LectureSubject::new), lectureSubjectDto.get());
        return lectureSubjectDto;
    }

    @Override
    public LectureSubjectDto add(LectureSubjectDto lectureSubjectDto) {
        LectureSubject lectureSubject = new LectureSubject();
        dtoToEntity(lectureSubjectDto, lectureSubject);
        lectureSubjectRepository.save(lectureSubject);
        entityToDto(lectureSubject, lectureSubjectDto);
        return lectureSubjectDto;
    }

    @Override
    public void delete(LectureSubjectDto lectureSubjectDto) {
        LectureSubject lectureSubject = new LectureSubject();
        dtoToEntity(lectureSubjectDto, lectureSubject);
        lectureSubjectRepository.delete(lectureSubject);
    }

    @Override
    public LectureSubjectDto update(LectureSubjectDto lectureSubjectDto) {
        Optional<LectureSubjectDto> optionalLectureSubjectDto = Optional.of(new LectureSubjectDto());
        LectureSubject lectureSubject = new LectureSubject();
        dtoToEntity(optionalLectureSubjectDto.get(),lectureSubject);
        entityToDto(lectureSubjectRepository.save(lectureSubject), lectureSubjectDto);
        return lectureSubjectDto;
    }

    protected void entityToDto(LectureSubject lectureSubject, LectureSubjectDto lectureSubjectDto) {

        lectureSubjectDto.setId(lectureSubject.getId());
        lectureSubjectDto.setSubjectName(lectureSubject.getSubjectName());
    }

    protected void dtoToEntity(LectureSubjectDto lectureSubjectDto, LectureSubject lectureSubject)
    {
        lectureSubject.setId(lectureSubjectDto.getId());
        lectureSubject.setSubjectName(lectureSubjectDto.getSubjectName());
    }
}
