package model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Embedded;

@MappedSuperclass
public abstract class Shape {
    @Embedded
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
