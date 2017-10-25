package com.test.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.Table;


public enum UserType {
    LIBRARIAN("Библиотекарь"),
    READER("Читатель");

    private final String description;

    UserType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean equals(UserType newUserType){
        return newUserType.getDescription().equals(this.getDescription());
    }
}
