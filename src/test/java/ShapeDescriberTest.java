import model.Shape;
import model.Color;
import model.Rectangle;
import model.ShapeDescriber;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShapeDescriberTest {

    @Test
    void testDescribeWithValidShape() {
        ShapeDescriber describer = new ShapeDescriber();
        Color color = new Color(255, 0, 0, 255);
        Shape rectangle = new Rectangle(5, 10, color);
        LogCaptor logCaptor = LogCaptor.forClass(ShapeDescriber.class);

        describer.describe(rectangle);

        List<String> logs = logCaptor.getInfoLogs();
        assertEquals(4, logs.size());
        assertTrue(logs.get(0).contains("Shape Type: Rectangle"));
        assertTrue(logs.get(1).contains("Color: Red: 255, Green: 0, Blue: 0, Alpha: 255"));
        assertTrue(logs.get(2).contains("Area: 50.0"));
        assertTrue(logs.get(3).contains("Perimeter: 30.0"));
    }

    @Test
    void testDescribeWithNullShape() {
        ShapeDescriber describer = new ShapeDescriber();
        LogCaptor logCaptor = LogCaptor.forClass(ShapeDescriber.class);

        describer.describe(null);

        List<String> warnLogs = logCaptor.getWarnLogs();
        assertEquals(1, warnLogs.size());
        assertTrue(warnLogs.get(0).contains("Shape is null. Cannot describe."));
    }
}
