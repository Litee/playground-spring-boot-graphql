package ru.lipatkin.playground.spring.boot.graphql.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class Author {
    private final int id;
    private final String name;
    private final Collection<Book> books = new ArrayList<>();
}
