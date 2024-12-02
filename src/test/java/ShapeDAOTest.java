import model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeDAOTest {
    private static ShapeDAO shapeDAO;

    @BeforeAll
    static void setUp() {
        shapeDAO = new ShapeDAO();
    }

    @AfterAll
    static void tearDown() {
        shapeDAO.close();
    }

    @Test
    void testSaveAndRetrieveShape() {
        Circle circle = new Circle(5, new Color(255, 0, 0));
        shapeDAO.saveShape(circle);

        Circle retrievedCircle = (Circle) shapeDAO.getShape(Circle.class, circle.getId());
        assertNotNull(retrievedCircle);
        assertEquals(5, retrievedCircle.getRadius());
        assertEquals(78.53981633974483, retrievedCircle.getArea(), 0.0001);
    }

    @Test
    void testUpdateShape() {
        Circle circle = new Circle(10, new Color(0, 255, 0));
        shapeDAO.saveShape(circle);

        circle.setRadius(20);
        shapeDAO.updateShape(circle);

        Circle updatedCircle = (Circle) shapeDAO.getShape(Circle.class, circle.getId());
        assertNotNull(updatedCircle);
        assertEquals(20, updatedCircle.getRadius());
        assertEquals(1256.6370614359173, updatedCircle.getArea(), 0.0001);
    }

    @Test
    void testDeleteShape() {
        Circle circle = new Circle(7, new Color(0, 0, 255));
        shapeDAO.saveShape(circle);

        shapeDAO.deleteShape(circle);

        Circle deletedCircle = (Circle) shapeDAO.getShape(Circle.class, circle.getId());
        assertNull(deletedCircle);
    }

    @Test
    void testSaveMultipleShapes() {
        Circle circle = new Circle(5, new Color(255, 255, 0));
        Triangle triangle = new Triangle(3, 4, 5, new Color(0, 255, 255));

        shapeDAO.saveShape(circle);
        shapeDAO.saveShape(triangle);

        Circle retrievedCircle = (Circle) shapeDAO.getShape(Circle.class, circle.getId());
        Triangle retrievedTriangle = (Triangle) shapeDAO.getShape(Triangle.class, triangle.getId());

        assertNotNull(retrievedCircle);
        assertNotNull(retrievedTriangle);

        assertEquals(5, retrievedCircle.getRadius());
        assertEquals(6, retrievedTriangle.getArea(), 0.0001);
    }
}
