package ru.lipatkin.playground.spring.boot.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lipatkin.playground.spring.boot.graphql.model.Author;
import ru.lipatkin.playground.spring.boot.graphql.model.Book;
import ru.lipatkin.playground.spring.boot.graphql.storage.SimpleDataStorage;

import java.util.List;
import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private SimpleDataStorage dataStorage;

    public Optional<Book> changeBookTitle(int id, String newTitle) {
        Optional<Book> book = dataStorage.getAllBooks().stream().filter(it -> it.getId() == id).findFirst();
        book.ifPresent(book1 -> book1.setTitle(newTitle));
        return book;
    }
}
