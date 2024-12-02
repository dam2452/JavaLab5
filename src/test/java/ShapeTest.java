import model.Shape;
import model.Color;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    static class TestShape extends Shape {
        private final double area;
        private final double perimeter;

        public TestShape(Color color, double area, double perimeter) {
            super(color);
            this.area = area;
            this.perimeter = perimeter;
        }

        @Override
        public double getArea() {
            return area;
        }

        @Override
        public double getPerimeter() {
            return perimeter;
        }
    }

    static class TestShapeWithoutColor extends Shape {
        private final double area;
        private final double perimeter;

        public TestShapeWithoutColor(double area, double perimeter) {
            super();
            this.area = area;
            this.perimeter = perimeter;
        }

        @Override
        public double getArea() {
            return area;
        }

        @Override
        public double getPerimeter() {
            return perimeter;
        }
    }

    @Test
    void testConstructorWithValidColor() {
        Color color = new Color(255, 0, 0, 255);
        Shape shape = new TestShape(color, 100.0, 50.0);

        assertNotNull(shape.getColor());
        assertEquals(color, shape.getColor());
    }

    @Test
    void testConstructorWithNullColor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TestShape(null, 100.0, 50.0);
        });
    }

    @Test
    void testGetColor() {
        Color color = new Color(50, 100, 150, 200);
        Shape shape = new TestShape(color, 100.0, 50.0);

        assertEquals(color, shape.getColor());
    }

    @Test
    void testGetColorDescription() {
        Color color = new Color(255, 100, 50, 200);
        Shape shape = new TestShape(color, 100.0, 50.0);

        String expectedDescription = "Red: 255, Green: 100, Blue: 50, Alpha: 200";
        assertEquals(expectedDescription, shape.getColorDescription());
    }

    @Test
    void testGetArea() {
        Color color = new Color(0, 255, 0, 255);
        Shape shape = new TestShape(color, 64.5, 50.0);

        assertEquals(64.5, shape.getArea());
    }

    @Test
    void testGetPerimeter() {
        Color color = new Color(0, 0, 255, 255);
        Shape shape = new TestShape(color, 64.5, 30.0);

        assertEquals(30.0, shape.getPerimeter());
    }

    @Test
    void testShapeWithoutColor() {
        Shape shape = new TestShapeWithoutColor(100.0, 50.0);

        assertNull(shape.getColor());

        assertEquals(100.0, shape.getArea());
        assertEquals(50.0, shape.getPerimeter());

        assertThrows(NullPointerException.class, shape::getColorDescription);
    }
}
