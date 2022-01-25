package com.example.hm50;

public class Contact {
    private String name;
    private Integer image;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contact(String name, Integer image, Integer id) {
        this.name = name;
        this.image = image;
        this.id = id;
    }
}
