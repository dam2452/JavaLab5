package org.example.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ShapeDAO {
    private final SessionFactory sessionFactory;

    public ShapeDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void saveShape(Shape shape) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(shape);
            session.getTransaction().commit();
        }
    }

    public Shape getShape(Class<? extends Shape> clazz, Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(clazz, id);
        }
    }

    public void updateShape(Shape shape) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(shape);
            session.getTransaction().commit();
        }
    }

    public void deleteShape(Shape shape) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(shape);
            session.getTransaction().commit();
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
