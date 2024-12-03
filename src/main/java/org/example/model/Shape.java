package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected Color color;

    protected Shape() {}

    public Shape(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public Color getColor() {
        return color;
    }

    public String getColorDescription() {
        return String.format("Red: %d, Green: %d, Blue: %d, Alpha: %d",
                color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}
