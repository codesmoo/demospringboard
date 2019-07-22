package me.codesmoo.demospringboard.service;

import me.codesmoo.demospringboard.domain.posts.PostsRepository;
import me.codesmoo.demospringboard.domain.posts.PostsSaveRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostsService {
    private PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional
    public Long save(PostsSaveRequestDTO dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
