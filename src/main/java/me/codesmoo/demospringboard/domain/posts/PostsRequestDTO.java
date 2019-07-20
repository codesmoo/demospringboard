package me.codesmoo.demospringboard.domain.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.codesmoo.demospringboard.domain.posts.Posts;

@Getter
@Setter
@NoArgsConstructor
public class PostsRequestDTO {

    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
