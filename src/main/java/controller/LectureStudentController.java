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
    @Autowired
    private LectureStudentRepository lectureStudentRepository;

    public LectureStudentController(LectureStudentService lectureStudentService) {
        this.lectureStudentService = lectureStudentService;
    }


    @GetMapping("/getall")
    private @ResponseBody List<LectureStudentDto> getAll(Integer id)
    {
        return lectureStudentService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public @ResponseBody Optional<LectureStudentDto> getById(@PathVariable Integer id)
    {
        return lectureStudentService.getById(id);
    }

    @PostMapping("/add")
    private void add(@RequestBody LectureStudentDto lectureStudentDto)
    {
        lectureStudentService.add(lectureStudentDto);
    }

    @DeleteMapping("/delete")
    private void delete(@RequestBody LectureStudentDto lectureStudentDto)
    {
        lectureStudentService.delete(lectureStudentDto);
    }

    @PutMapping("/update")
    private void update(@RequestBody LectureStudentDto lectureStudentDto)
    {
        lectureStudentService.update(lectureStudentDto);
    }
}
