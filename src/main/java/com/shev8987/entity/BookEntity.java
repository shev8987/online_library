package com.shev8987.entity;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "online_lib")
public class BookEntity {

    @Id
    @SequenceGenerator(name = "book_id_generator", sequenceName = "book_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_generator")
    private Long id;

    private String title;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "icon_id")
    private Long iconId;

    @Column(name = "file_id")
    private Long fileId;

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long author) {
        this.authorId = author;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genre_id) {
        this.genreId = genre_id;
    }

    public Long getIconId() {
        return iconId;
    }

    public void setIconId(Long icon_id) {
        this.iconId = icon_id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long file_id) {
        this.fileId = file_id;
    }

}
