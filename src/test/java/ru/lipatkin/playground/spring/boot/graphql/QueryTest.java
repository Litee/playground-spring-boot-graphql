package ru.lipatkin.playground.spring.boot.graphql;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
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
    public void testLoadingBooks() {
        ResponseEntity<String> responseEntity = postGraphql("{books{id, title}}");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals("{\"data\":{\"books\":[{\"id\":0,\"title\":\"Foundation\"},{\"id\":1,\"title\":\"I, robot\"},{\"id\":2,\"title\":\"Star Troopers\"},{\"id\":3,\"title\":\"Double star\"}]}}", responseEntity.getBody(), false);
    }

    @Test
    @SneakyThrows
    public void testGettingSingleBook() {
        ResponseEntity<String> responseEntity = postGraphql("{book(id:1){id, title}}");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals("{\"data\":{\"book\":{\"id\":1,\"title\":\"I, robot\"}}}", responseEntity.getBody(), false);
    }

    private ResponseEntity<String> postGraphql(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("{\"query\":\"" + query + "\"}", headers);

        return restTemplate.postForEntity("/graphql", entity, String.class);
    }

}
