package me.codesmoo.demospringboard.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void load_main_page() {
        //when
        String body = this.restTemplate.getForObject("/",String.class);

        //then
        assertThat(body).contains("웹 서비스");
    }
}
