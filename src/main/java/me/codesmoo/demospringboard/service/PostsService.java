package me.codesmoo.demospringboard.service;

import lombok.AllArgsConstructor;
import me.codesmoo.demospringboard.domain.posts.PostsRepository;
import me.codesmoo.demospringboard.dto.posts.PostsMainResponseDTO;
import me.codesmoo.demospringboard.dto.posts.PostsSaveRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsMainResponseDTO> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long save(PostsSaveRequestDTO dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
