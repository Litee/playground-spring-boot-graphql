package ru.lipatkin.playground.spring.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import ru.lipatkin.playground.spring.boot.graphql.model.Author;
import ru.lipatkin.playground.spring.boot.graphql.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Book> books() {
        return new ArrayList<>();
    }

    public Book book(Integer id) {
        return null;
    }

    public List<Author> authors() {
        return new ArrayList<>();
    }

    public Author author(Integer id) {
        return null;
    }
}
