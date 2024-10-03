package com.works.models;

import jakarta.ws.rs.QueryParam;

public class Search {

    @QueryParam("name")
    private String name;

    @QueryParam("age")
    private Integer age;

    public Search() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
