package me.codesmoo.demospringboard.web;

import lombok.AllArgsConstructor;
import me.codesmoo.demospringboard.dto.posts.PostsMainResponseDTO;
import me.codesmoo.demospringboard.dto.posts.PostsSaveRequestDTO;
import me.codesmoo.demospringboard.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * handlebars 이용해서 return값 viewResolver로 보내기 위해서는
 * (prefix: src/main/resources/templates, suffix: .hbs)
 * @RestController 말고 @Controller 이용
 */

@Controller
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/posts")
    public String savePosts(@RequestBody PostsSaveRequestDTO dto) {
        postsService.save(dto);
        return "main";
    }

}
