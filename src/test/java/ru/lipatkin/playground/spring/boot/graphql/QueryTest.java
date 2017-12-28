package ru.lipatkin.playground.spring.boot.graphql;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class QueryTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @SneakyThrows
    public void testPost() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("{\"query\":\"{books{id}}\"}", headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/graphql", entity, String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("{\"data\":{\"books\":[{\"id\":0},{\"id\":1},{\"id\":2},{\"id\":3}]}}", responseEntity.getBody());
    }

}
