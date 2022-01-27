package com.shev8987.model;

import com.shev8987.entity.AuthorEntity;

public class AuthorModel extends AuthorEntity {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorModel() {
    }

    public AuthorModel(AuthorEntity entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
    }
}
