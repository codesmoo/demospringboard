package me.codesmoo.demospringboard.web;

import me.codesmoo.demospringboard.domain.posts.PostsRepository;
import me.codesmoo.demospringboard.domain.posts.PostsSaveRequestDTO;
import me.codesmoo.demospringboard.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * handlebars 이용해서 return값 viewResolver로 보내기 위해서는
 * (prefix: src/main/resources/templates, suffix: .hbs)
 * @RestController 말고 @Controller 이용
 */

@Controller
public class WebRestController {

    private PostsService postsService;

    public WebRestController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/")
    public String main() {
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
