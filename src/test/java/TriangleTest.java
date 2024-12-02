import model.Triangle;
import model.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testValidTriangle() {
        Color color = new Color(0, 255, 0);
        Triangle triangle = new Triangle(3, 4, 5, color);

        assertEquals(3, triangle.getSideA());
        assertEquals(4, triangle.getSideB());
        assertEquals(5, triangle.getSideC());
        assertEquals(12, triangle.getPerimeter(), 0.0001);
        assertEquals(6, triangle.getArea(), 0.0001);
    }

    @Test
    void testInvalidTriangle() {
        Color color = new Color(255, 0, 0);
        assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 2, 10, color));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(0, 0, 0, color));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(-3, 4, 5, color));
    }

    @Test
    void testGetId() {
        Color color = new Color(0, 0, 255);
        Triangle triangle = new Triangle(3, 4, 5, color);

        // Id może być null, ponieważ jest generowane po zapisaniu w bazie danych
        assertNull(triangle.getId());
    }

    @Test
    void testTriangleColor() {
        Color color = new Color(123, 45, 67);
        Triangle triangle = new Triangle(3, 4, 5, color);

        assertEquals("Red: 123, Green: 45, Blue: 67, Alpha: 255", triangle.getColorDescription());
    }
}
