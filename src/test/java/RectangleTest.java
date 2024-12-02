import model.Color;
import model.Rectangle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @Test
    public void testArea() {
        Rectangle rectangle = new Rectangle(5, 10, new Color(255, 0, 0));
        assertEquals(50, rectangle.getArea());
    }

    @Test
    public void testPerimeter() {
        Rectangle rectangle = new Rectangle(5, 10, new Color(255, 0, 0));
        assertEquals(30, rectangle.getPerimeter());
    }

    @Test
    public void testColor() {
        Color color = new Color(255, 0, 0);
        Rectangle rectangle = new Rectangle(5, 10, color);
        assertEquals(color, rectangle.getColor());
    }
}
