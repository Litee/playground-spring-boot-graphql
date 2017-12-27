package ru.lipatkin.playground.spring.boot.graphql.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class Book {
    private final int id;
    private final String title;
    private final Collection<Author> authors = new ArrayList<>();
}
