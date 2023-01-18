package service.Impl;

import dto.LectureDto;
import dto.LecturerDto;
import entity.Lecture;
import entity.Lecturer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LecturerRepository;
import service.BaseService;
import service.LecturerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;


    @Override
    public List<LecturerDto> getAll() {
        List<LecturerDto> lecturerDtoList = new ArrayList<>();
        lecturerRepository.findAll().forEach(lecturer -> {
            LecturerDto lecturerDto = new LecturerDto();
            entityToDto(lecturer, lecturerDto);
            lecturerDtoList.add(lecturerDto);
        });
        return lecturerDtoList;
    }

    @Override
    public Optional<LecturerDto> getById(Integer id) {
        Optional<LecturerDto> lecturerDto = Optional.of(new LecturerDto());
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        entityToDto(lecturer.orElseGet(Lecturer::new), lecturerDto.get());
        return lecturerDto;
    }

    @Override
    public LecturerDto add(LecturerDto lecturerDto) {
        Lecturer lecturer = new Lecturer();
        dtoToEntity(lecturerDto,lecturer);
        lecturerRepository.save(lecturer);
        return lecturerDto;
    }

    @Override
    public void delete(LecturerDto lecturerDto) {
        Lecturer lecturer = new Lecturer();
        dtoToEntity(lecturerDto, lecturer);
        lecturerRepository.delete(lecturer);
    }

    @Override
    public LecturerDto update(LecturerDto lecturerDto) {
        Optional<LecturerDto> optionalLecturerDto = Optional.of(new LecturerDto());
        Lecturer lecturer = new Lecturer();
        dtoToEntity(optionalLecturerDto.get(), lecturer);
        entityToDto(lecturerRepository.save(lecturer), lecturerDto);
        return lecturerDto;
    }

    protected void entityToDto (Lecturer lecturer, LecturerDto lecturerDto)
    {
        lecturer.setId(lecturerDto.getId());
        lecturer.setLecturerAge(lecturerDto.getLecturerAge());
    }

    protected void dtoToEntity (LecturerDto lecturerDto, Lecturer lecturer)
    {
        lecturerDto.setId(lecturer.getId());
        lecturerDto.setLecturerAge(lecturer.getLecturerAge());
    }


}
