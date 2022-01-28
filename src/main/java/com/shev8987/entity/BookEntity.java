package com.shev8987.entity;

import org.springframework.data.annotation.Id;;

/**
 * Таблица "книга" в БД
 */
public class BookEntity {

    @Id
    private Long id;

    private String title;

    private Long authorId;

    private Long genreId;

    private Long iconId;

    private Long fileId;

    public BookEntity() {

    }

    public BookEntity(Long id, String title, Long authorId, Long genreId, Long iconId, Long fileId) {

        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
        this.iconId = iconId;
        this.fileId = fileId;
    }

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
