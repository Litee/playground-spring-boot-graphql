package ru.lipatkin.playground.spring.boot.graphql.storage;

import org.springframework.stereotype.Repository;
import ru.lipatkin.playground.spring.boot.graphql.model.Author;
import ru.lipatkin.playground.spring.boot.graphql.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SimpleDataStorage {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public SimpleDataStorage() {
        Author author1 = new Author(0, "Isaak Asimov");
        Author author2 = new Author(1, "Robert Heinlein");

        Book book1 = new Book(0, "Foundation");
        Book book2 = new Book(1, "I, robot");
        Book book3 = new Book(2, "Star Troopers");
        Book book4 = new Book(3, "Double star");

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author2.getBooks().add(book3);
        author2.getBooks().add(book4);

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author1);
        book3.getAuthors().add(author2);
        book4.getAuthors().add(author2);

        books.addAll(Arrays.asList(book1, book2, book3, book4));
        authors.addAll(Arrays.asList(author1, author2));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }
}
