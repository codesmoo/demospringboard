package me.codesmoo.demospringboard.dto.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.codesmoo.demospringboard.domain.posts.Posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    public String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");

    }
}
