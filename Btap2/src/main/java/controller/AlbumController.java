package controller;

import model.Album;
import model.Category;
import model.MusicForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.AlbumService;

import java.io.File;
import java.util.List;

@Controller
public class AlbumController {

    @Value("D:/Module4/Bai4/Btap2/src/main/webapp/WEB-INF/file/")
    public String fileUpload;
    AlbumService albumService = new AlbumService();

    @GetMapping("/home")
    public ModelAndView index() {
        List<Album> list = albumService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("musics",list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(@ModelAttribute("musicForm") MusicForm form){
        List<Category> categoryList = albumService.findAllCa();
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("categories",categoryList);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute("musicForm") MusicForm form){
        MultipartFile multipartFile = form.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(form.getLink().getBytes(),new File(fileUpload,fileName));
        } catch (Exception e){
            e.printStackTrace();
        }
        Album album = new Album(form.getId(),form.getName(),form.getSinger(),form.getType(),fileName);
        albumService.save(album);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        modelAndView.addObject("message", "Create success");
        return modelAndView;
    }
}
