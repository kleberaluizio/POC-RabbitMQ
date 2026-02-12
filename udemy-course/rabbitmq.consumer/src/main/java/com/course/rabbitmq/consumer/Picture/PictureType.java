package com.course.rabbitmq.consumer.Picture;

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
