package ru.lipatkin.playground.spring.boot.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

abstract class GraphqlTestBase {
    @Autowired
    private TestRestTemplate restTemplate;

    ResponseEntity<String> postGraphql(String query, String variables) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("{\"query\":\"" + query + "\",\"variables\":" + variables + "}", headers);

        return restTemplate.postForEntity("/graphql", entity, String.class);
    }

}