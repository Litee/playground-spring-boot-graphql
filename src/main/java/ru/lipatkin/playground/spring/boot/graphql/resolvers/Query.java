package ru.lipatkin.playground.spring.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lipatkin.playground.spring.boot.graphql.model.Author;
import ru.lipatkin.playground.spring.boot.graphql.model.Book;
import ru.lipatkin.playground.spring.boot.graphql.storage.SimpleDataStorage;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private SimpleDataStorage dataStorage;

    public List<Book> books() {
        return dataStorage.getAllBooks();
    }

    public Optional<Book> book(Integer id) {
        return dataStorage.getAllBooks().stream().filter(it -> it.getId() == id).findFirst();
    }
}

