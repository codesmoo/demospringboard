package me.codesmoo.demospringboard.web;

import me.codesmoo.demospringboard.domain.posts.PostsRepository;
import me.codesmoo.demospringboard.domain.posts.PostsRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebRestController {

    private PostsRepository postsRepository;

    public WebRestController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
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
    public void savePosts(@RequestBody PostsRequestDTO dto) {
        postsRepository.save(dto.toEntity());
    }

}
