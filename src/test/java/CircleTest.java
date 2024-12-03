import org.example.model.Circle;
import org.example.model.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testValidCircle() {
        Color color = new Color(0, 0, 255);
        Circle circle = new Circle(5, color);

        assertEquals(5, circle.getRadius());
        assertEquals(78.53981633974483, circle.getArea(), 0.0001);
        assertEquals(31.41592653589793, circle.getPerimeter(), 0.0001);
    }

    @Test
    void testInvalidRadius() {
        Color color = new Color(255, 255, 255);
        assertThrows(IllegalArgumentException.class, () -> new Circle(0, color));
        assertThrows(IllegalArgumentException.class, () -> new Circle(-5, color));
    }

    @Test
    void testSetRadiusValidValue() {
        Color color = new Color(255, 0, 0);
        Circle circle = new Circle(10, color);

        circle.setRadius(15);
        assertEquals(15, circle.getRadius());
        assertEquals(706.85775, circle.getArea(), 0.001);
        assertEquals(94.24778, circle.getPerimeter(), 0.0001);
    }

    @Test
    void testSetRadiusInvalidValue() {
        Color color = new Color(0, 255, 0);
        Circle circle = new Circle(10, color);

        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(0));
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(-1));
    }

    @Test
    void testGetId() {
        Color color = new Color(0, 0, 255);
        Circle circle = new Circle(5, color);

        // Id może być null, ponieważ jest generowane po zapisaniu w bazie danych
        assertNull(circle.getId());
    }

    @Test
    void testCircleColor() {
        Color color = new Color(123, 45, 67);
        Circle circle = new Circle(7, color);

        assertEquals("Red: 123, Green: 45, Blue: 67, Alpha: 255", circle.getColorDescription());
    }
}
