package me.codesmoo.demospringboard.web;

import lombok.AllArgsConstructor;
import me.codesmoo.demospringboard.dto.posts.PostsMainResponseDTO;
import me.codesmoo.demospringboard.dto.posts.PostsSaveRequestDTO;
import me.codesmoo.demospringboard.service.PostsService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * handlebars 이용해서 return값 viewResolver로 보내기 위해서는
 * (prefix: src/main/resources/templates, suffix: .hbs)
 * @RestController 말고 @Controller 이용
 */

@RestController
@AllArgsConstructor
public class WebRestController {

    private Environment environment;

    @GetMapping("/profile")
    public String getProfile() {
        return Arrays.stream(environment.getActiveProfiles()).findFirst().orElse("");
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
