package controller;

import model.UppFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.UppFileService;

import java.io.File;
import java.io.IOException;

@Controller
public class UppFileController {
    UppFileService uppFileService = new UppFileService();

    @RequestMapping("/upp")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",uppFileService.list);
        return modelAndView;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int index){
        uppFileService.delete(index);
        return "redirect:/upp";
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
    modelAndView.addObject("up", uppFileService.list.get(index));
    return modelAndView;
    }
    @PostMapping("/edit")
    public String edit(@RequestParam MultipartFile UppImg, @RequestParam int index, @ModelAttribute("up") UppFile uppFile){
        String nameImg = UppImg.getOriginalFilename();

        try {
            FileCopyUtils.copy(UppImg.getBytes(), new File("D:/Module4/Bai4/TH4/src/main/webapp/file/" + nameImg));
        String urlImg = "up/file/" + nameImg;
        uppFile.setImg(urlImg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        uppFileService.edit(uppFile,index);
        return "redirect:/upp";
    }

}
