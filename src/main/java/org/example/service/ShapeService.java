package org.example.service;

import org.example.model.Shape;
import org.example.model.ShapeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeService {
    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public Shape saveShape(Shape shape) {
        return shapeRepository.save(shape);
    }

    public List<Shape> getAllShapes() {
        return shapeRepository.findAll();
    }
}
