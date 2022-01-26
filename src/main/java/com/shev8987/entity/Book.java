package com.shev8987.entity;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "online_lib")
public class Book {

    @Id
    @SequenceGenerator(name = "book_id_generator", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_generator")
    private Long id;

    private String title;

    private Long author_id;

    private Long genre_id;

    private Long icon_id;

    private Long file_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author) {
        this.author_id = author;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public Long getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(Long icon_id) {
        this.icon_id = icon_id;
    }

    public Long getFile_id() {
        return file_id;
    }

    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

}
