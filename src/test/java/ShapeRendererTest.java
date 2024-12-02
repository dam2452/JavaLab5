import model.Circle;
import model.Color;
import model.Rectangle;
import model.Shape;
import model.ShapeRenderer;
import model.Triangle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.github.stefanbirkner.systemlambda.SystemLambda;

import java.util.List;

class ShapeRendererTest {

    @Test
    void testRenderRectangle() throws Exception {
        Color red = new Color(255, 0, 0);
        Rectangle rectangle = new Rectangle(4, 2, red);
        ShapeRenderer renderer = new ShapeRenderer();

        String output = SystemLambda.tapSystemOut(() -> {
            renderer.renderShapes(List.of(rectangle));
        });

        assertTrue(output.contains("Rendering shape: Rectangle"));
        assertTrue(output.contains("Color: Red: 255, Green: 0, Blue: 0, Alpha: 255"));
        assertTrue(output.contains("****"));
        assertTrue(output.contains("****"));
    }

    @Test
    void testRenderRectangleWithLargeDimensions() throws Exception {
        Color blue = new Color(0, 0, 255);
        Rectangle rectangle = new Rectangle(10, 5, blue);
        ShapeRenderer renderer = new ShapeRenderer();

        String output = SystemLambda.tapSystemOut(() -> {
            renderer.renderShapes(List.of(rectangle));
        });

        assertTrue(output.contains("Rendering shape: Rectangle"));
        assertTrue(output.contains("Color: Red: 0, Green: 0, Blue: 255, Alpha: 255"));
        assertTrue(output.contains("**********"));
    }

    @Test
    void testRenderTriangle() throws Exception {
        Color green = new Color(0, 255, 0);
        Triangle triangle = new Triangle(3, 4, 5, green);
        ShapeRenderer renderer = new ShapeRenderer();

        String output = SystemLambda.tapSystemOut(() -> {
            renderer.renderShapes(List.of(triangle));
        });

        assertTrue(output.contains("Rendering shape: Triangle"));
        assertTrue(output.contains("Color: Red: 0, Green: 255, Blue: 0, Alpha: 255"));
        assertTrue(output.contains("*"));
        assertTrue(output.contains("**"));
        assertTrue(output.contains("***"));
    }

    @Test
    void testRenderCircle() throws Exception {
        Color yellow = new Color(255, 255, 0);
        Circle circle = new Circle(3, yellow);
        ShapeRenderer renderer = new ShapeRenderer();

        String output = SystemLambda.tapSystemOut(() -> {
            renderer.renderShapes(List.of(circle));
        });

        assertTrue(output.contains("Rendering shape: Circle"));
        assertTrue(output.contains("Color: Red: 255, Green: 255, Blue: 0, Alpha: 255"));
        assertTrue(output.contains("*"));
    }

    @Test
    void testRenderUnknownShape() throws Exception {
        ShapeRenderer renderer = new ShapeRenderer();
        Shape unknownShape = new Shape(new Color(0, 0, 0)) {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };

        String output = SystemLambda.tapSystemOut(() -> {
            renderer.renderShapes(List.of(unknownShape));
        });

        assertTrue(output.contains("Rendering shape:"));
        assertTrue(output.contains("Unknown shape. Cannot render."));
    }

    @Test
    void testRenderEmptyList() throws Exception {
        ShapeRenderer renderer = new ShapeRenderer();

        String output = SystemLambda.tapSystemOut(() -> {
            renderer.renderShapes(List.of());
        });

        assertTrue(output.trim().isEmpty());
    }

    @Test
    void testGetColorCode() throws Exception {
        Color magenta = new Color(255, 0, 255);
        ShapeRenderer renderer = new ShapeRenderer();

        String colorCode = renderer.getColorCode(magenta);

        assertEquals("\033[38;2;255;0;255m", colorCode);
    }
}
