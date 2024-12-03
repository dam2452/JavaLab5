package org.example;

import java.util.Arrays;
import java.util.List;
import org.example.model.Color;
import org.example.model.Rectangle;
import org.example.model.Shape;
import org.example.model.ShapeDescriber;
import org.example.model.ShapeRenderer;
import org.example.model.Triangle;
import org.example.model.Circle;

public class Main {
    public static void main(String[] args) {
        Color red = new Color(255, 0, 0);
        Color green = new Color(0, 255, 0, 128);
        Color blue = new Color(0, 0, 255);

        Rectangle rectangle = new Rectangle(5, 10, red);
        Triangle triangle = new Triangle(3, 4, 5, green);
        Circle circle = new Circle(5, blue);

        ShapeDescriber describer = new ShapeDescriber();
        describer.describe(rectangle);
        describer.describe(triangle);
        describer.describe(circle);

        ShapeRenderer renderer = new ShapeRenderer();
        List<Shape> shapes = Arrays.asList(rectangle, triangle, circle);
        renderer.renderShapes(shapes);
    }
}
