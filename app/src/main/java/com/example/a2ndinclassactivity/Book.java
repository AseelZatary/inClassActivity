package com.example.a2ndinclassactivity;

public class Book {
    private String title;
    private String name;
    private String pages;

    public Book(String title, String name, String pages) {
        this.title = title;
        this.name = name;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getPages() {
        return pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}
