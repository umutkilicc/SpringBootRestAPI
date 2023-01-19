package controller;

import dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getall")
    public @ResponseBody List<StudentDto> getAll()
    {
        return studentService.getAll();
    }

    @GetMapping("/getbyid")
    public @ResponseBody Optional<StudentDto> getById(@PathVariable Integer id)
    {
        return studentService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody StudentDto studentDto)
    {
        studentService.add(studentDto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody StudentDto studentDto)
    {
        studentService.delete(studentDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody StudentDto studentDto)
    {
        studentService.update(studentDto);
    }
}
