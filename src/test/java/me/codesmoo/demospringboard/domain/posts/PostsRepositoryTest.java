package me.codesmoo.demospringboard.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    Logger logger = LoggerFactory.getLogger(PostsRepositoryTest.class);

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
    public void load_posts() {
        //given
        postsRepository.save(Posts.builder()
                .title("첫 게시글")
                .content("냉무")
                .author("송성학")
                .build());

        //when
        List<Posts> postList = postsRepository.findAll();
        for(Posts posts :postList){
            logger.info(posts.toString());
        }

        //then
        Posts posts = postList.get(0);
        assertThat(posts.getAuthor()).isEqualTo("송성학");
    }
}
