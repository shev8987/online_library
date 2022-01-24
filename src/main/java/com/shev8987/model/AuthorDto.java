package com.shev8987.model;

import java.util.List;

public class AuthorDto {

    public Integer Id;

    public String Name;

    public String LastName;

    public List<BookDto> Books;

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public List<BookDto> getBooks() {
        return Books;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setBooks(List<BookDto> books) {
        Books = books;
    }


}
