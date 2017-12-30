package ru.lipatkin.playground.spring.boot.graphql;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@DirtiesContext
public class MutationTest extends GraphqlTestBase {

    @Test
    @SneakyThrows
    public void shouldChangeBookTitle() {
        ResponseEntity<String> responseEntity = postGraphql(
                "mutation ChangeBookTitle($id:Int!,$newTitle:String!){changeBookTitle(id:$id,newTitle:$newTitle){id,title}}",
                "{\"id\": 1, \"newTitle\": \"New Title\"}");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals("{\"data\":{\"changeBookTitle\":{\"id\":1,\"title\":\"New Title\"}}}", responseEntity.getBody(), false);
    }
}
