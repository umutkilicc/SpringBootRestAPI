package controller;

import dto.LectureDto;
import dto.LecturerDto;
import entity.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.LecturerService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/lecturer")
public class LecturerController {
    @Autowired
    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/getall")
    public @ResponseBody List<LecturerDto> getAll()
    {
        return lecturerService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public @ResponseBody Optional<LecturerDto> getById(@PathVariable Integer id)
    {
        return lecturerService.getById(id);
    }

    @PostMapping("/add")
    public @ResponseBody  LecturerDto add(@RequestBody LecturerDto lecturerDto)
    {
        return lecturerService.add(lecturerDto);
    }

    @DeleteMapping("/delete")
    public @ResponseBody void delete(@RequestBody LecturerDto lecturerDto)
    {
        lecturerService.delete(lecturerDto);
    }


    @PutMapping("/update")
    public @ResponseBody LecturerDto update(@RequestBody LecturerDto lecturerDto)
    {
        return lecturerService.update(lecturerDto);
    }
}
