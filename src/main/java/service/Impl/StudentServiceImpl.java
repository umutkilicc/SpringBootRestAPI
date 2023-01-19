package service.Impl;

import dto.StudentDto;
import entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LecturerRepository;
import repository.StudentReporsitory;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentReporsitory studentReporsitory;

    public StudentServiceImpl(StudentReporsitory studentReporsitory) {
        this.studentReporsitory = studentReporsitory;
    }


    @Override
    public List<StudentDto> getAll() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentReporsitory.findAll().forEach(student -> {
            StudentDto studentDto = new StudentDto();
            entityToDto(student, studentDto);
            studentDtoList.add(studentDto);
        });
        return studentDtoList;
    }

    @Override
    public Optional<StudentDto> getById(Integer id) {
        Optional<StudentDto> studentDto = Optional.of(new StudentDto());
        Optional<Student> student = studentReporsitory.findById(id);
        entityToDto(student.orElseGet(Student::new), studentDto.get());
        return  studentDto;
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        Student student = new Student();
        dtoToEntity(studentDto, student);
        studentReporsitory.save(student);
        return studentDto;
    }

    @Override
    public void delete(StudentDto studentDto) {
        Student student = new Student();
        dtoToEntity(studentDto, student);
        studentReporsitory.delete(student);
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Optional<StudentDto> optionalStudentDto = Optional.of(new StudentDto());
        Student student = new Student();
        dtoToEntity(optionalStudentDto.get(), student);
        entityToDto(studentReporsitory.save(student), studentDto);
        return studentDto;
    }

    protected void entityToDto(Student student, StudentDto studentDto)
    {
        studentDto.setId(student.getId());
        studentDto.setStudentAge(student.getStudentAge());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setStudentNumber(student.getStudentNumber());
    }

    protected void dtoToEntity(StudentDto studentDto, Student student)
    {
        student.setId(studentDto.getId());
        student.setStudentAge(studentDto.getStudentAge());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentNumber(studentDto.getStudentNumber());
    }

}
