package me.codesmoo.demospringboard.service;

import me.codesmoo.demospringboard.domain.posts.Posts;
import me.codesmoo.demospringboard.domain.posts.PostsRepository;
import me.codesmoo.demospringboard.dto.posts.PostsSaveRequestDTO;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    Logger logger = LoggerFactory.getLogger(PostsServiceTest.class);

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        /**
         * 이후 테스트 코드에 영향을 끼치지 않기위해
         * 테스트 메소드가 끝날때 마다 repository 전체 비우는 코드
         */
        postsRepository.deleteAll();
    }

    @Test
    public void savePosts() {
        //given
        PostsSaveRequestDTO dto = PostsSaveRequestDTO.builder()
                .title("제목입니다")
                .content("내용이구요")
                .author("codesmoo")
                .build();

        //when
        Long save = postsService.save(dto);
        logger.info(save.toString());

        //then
        Posts posts = postsRepository.findAll().get(2);
        assertThat(posts.getTitle()).isEqualTo("제목입니다");
        assertThat(posts.getContent()).isEqualTo("내용이구요");
        assertThat(posts.getAuthor()).isEqualTo("codesmoo");

    }

}