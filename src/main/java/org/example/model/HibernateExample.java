package org.example.model;

import org.example.model.Circle;
import org.example.model.Color;
import org.example.model.ShapeDAO;

public class HibernateExample {
    public static void main(String[] args) {
        ShapeDAO shapeDAO = new ShapeDAO();

        Color red = new Color(255, 0, 0);
        Circle circle = new Circle(10, red);

        shapeDAO.saveShape(circle);
        System.out.println("Circle zapisano do bazy danych.");

        Circle retrievedCircle = (Circle) shapeDAO.getShape(Circle.class, circle.getId());
        System.out.println("Odczytano Circle z bazy danych: " + retrievedCircle.getArea());

        retrievedCircle.setRadius(20);
        shapeDAO.updateShape(retrievedCircle);
        System.out.println("Circle zaktualizowano w bazie danych.");

        shapeDAO.deleteShape(retrievedCircle);
        System.out.println("Circle usunięto z bazy danych.");

        shapeDAO.close();
    }
}
