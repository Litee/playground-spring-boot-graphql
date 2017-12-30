package ru.lipatkin.playground.spring.boot.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
public class Book {
    private final int id;
    private String title;
    private final Collection<Author> authors = new ArrayList<>();
}
