package controller;

import dto.LectureStudentDto;
import dto.LectureSubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.LectureSubjectService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/lecturesubject")
public class LectureSubjectController {

    @Autowired
    private final LectureSubjectService lectureSubjectService;

    public LectureSubjectController(LectureSubjectService lectureSubjectService) {
        this.lectureSubjectService = lectureSubjectService;
    }

    @GetMapping("/getall")
    public @ResponseBody List<LectureSubjectDto> getAll()
    {
        return lectureSubjectService.getAll();
    }

    @GetMapping("/getall")
    public @ResponseBody Optional<LectureSubjectDto> getById(@PathVariable Integer id)
    {
        return lectureSubjectService.getById(id);
    }

    @PostMapping("/add")
    public void add(LectureSubjectDto lectureSubjectDto)
    {
        lectureSubjectService.add(lectureSubjectDto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody LectureSubjectDto lectureSubjectDto)
    {
        lectureSubjectService.delete(lectureSubjectDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody LectureSubjectDto lectureSubjectDto)
    {
        lectureSubjectService.update(lectureSubjectDto);
    }
}
