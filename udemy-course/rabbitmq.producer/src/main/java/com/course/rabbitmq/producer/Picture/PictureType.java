package com.course.rabbitmq.producer.Picture;

public enum PictureType {
    JPG ("image"),
    PNG  ("image"),
    SVG  ("vector");

    private final String description;

    PictureType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
