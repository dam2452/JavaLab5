package org.example.model;


import java.util.List;

public class ShapeRenderer {

    public void renderShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println();
            System.out.println("Rendering shape: " + shape.getClass().getSimpleName());
            System.out.println("Color: " + shape.getColorDescription());

            switch (shape) {
                case Rectangle rectangle -> renderRectangle(rectangle);
                case Triangle triangle -> renderTriangle(triangle);
                case Circle circle -> renderCircle(circle);
                default -> System.out.println("Unknown shape. Cannot render.");
            }
        }
    }


    private void renderRectangle(Rectangle rectangle) {
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        String colorCode = getColorCode(rectangle.getColor());

        for (int i = 0; i < height; i++) {
            System.out.print(colorCode);
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println("\033[0m");
        }
    }

    private void renderTriangle(Triangle triangle) {
        int height = (int) triangle.getSideA();
        String colorCode = getColorCode(triangle.getColor());

        for (int i = 1; i <= height; i++) {
            System.out.print(colorCode);
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("\033[0m");
        }
    }

    private void renderCircle(Circle circle) {
        int radius = (int) circle.getRadius();
        String colorCode = getColorCode(circle.getColor());


        for (int y = -radius; y <= radius; y++) {
            System.out.print(colorCode);
            for (int x = -radius; x <= radius; x++) {
                if (x * x + y * y <= radius * radius) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("\033[0m");
        }
    }


    public String getColorCode(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        return String.format("\033[38;2;%d;%d;%dm", red, green, blue);
    }
}
