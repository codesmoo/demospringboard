package me.codesmoo.demospringboard.web;

import lombok.AllArgsConstructor;
import me.codesmoo.demospringboard.dto.posts.PostsSaveRequestDTO;
import me.codesmoo.demospringboard.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @PostMapping("/posts")
    public String savePosts(@RequestBody PostsSaveRequestDTO dto) {
        postsService.save(dto);
        return "main";
    }
}
