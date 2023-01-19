package controller;

import dto.LectureDto;
import dto.LectureStudentDto;
import entity.LectureStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.LectureStudentRepository;
import service.LectureStudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/lecturestudent")
public class LectureStudentController {

    @Autowired
    private final LectureStudentService lectureStudentService;
    public LectureStudentController(LectureStudentService lectureStudentService) {
        this.lectureStudentService = lectureStudentService;
    }


    @GetMapping("/getall")
    public @ResponseBody List<LectureStudentDto> getAll()
    {
        return lectureStudentService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public @ResponseBody Optional<LectureStudentDto> getById(@PathVariable Integer id)
    {
        return lectureStudentService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody LectureStudentDto lectureStudentDto)
    {
        lectureStudentService.add(lectureStudentDto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody LectureStudentDto lectureStudentDto)
    {
        lectureStudentService.delete(lectureStudentDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody LectureStudentDto lectureStudentDto)
    {
        lectureStudentService.update(lectureStudentDto);
    }
}
