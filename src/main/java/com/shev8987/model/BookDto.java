package com.shev8987.model;

import java.util.Arrays;
import java.util.Objects;

public class BookDto {

    public Integer id;

    public String name;

    public String genreName;

    public String authorName;

    public String description;

    public byte[] icon;

    public byte[] file;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genreName;
    }

    public void setGenre(String genreName) {
        this.genreName = genreName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return id.equals(bookDto.id)
                && name.equals(bookDto.name)
                && genreName.equals(bookDto.genreName)
                && authorName.equals(bookDto.authorName)
                && Objects.equals(description, bookDto.description)
                && Arrays.equals(icon, bookDto.icon)
                && Arrays.equals(file, bookDto.file);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, genreName, authorName, description);
        result = 31 * result + Arrays.hashCode(icon);
        result = 31 * result + Arrays.hashCode(file);
        return result;
    }
}
