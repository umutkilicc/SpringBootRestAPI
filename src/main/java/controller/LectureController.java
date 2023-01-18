package controller;

import dto.LectureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.LectureService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/lecture")
public class LectureController {

    @Autowired
    public final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/getall")
    public @ResponseBody List<LectureDto> getAll()
    {
        return lectureService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public @ResponseBody Optional<LectureDto> getById(@PathVariable Integer id)
    {
        return lectureService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody LectureDto lectureDto)
    {
        lectureService.add(lectureDto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody LectureDto lectureDto)
    {
        lectureService.delete(lectureDto);
    }

    @PutMapping("/update")
    public void  update(@RequestBody LectureDto lectureDto)
    {
        lectureService.update(lectureDto);
    }



}
