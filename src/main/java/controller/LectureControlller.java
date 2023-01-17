package controller;

import dto.LectureDto;
import entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.LectureService;
import service.LecturerService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/lecture")
public class LectureControlller {

    private LectureService lectureService;

    @GetMapping("/getall")
    public @ResponseBody  List<LectureDto> getAll()
    {
        return lectureService.getAll();
    }
}
