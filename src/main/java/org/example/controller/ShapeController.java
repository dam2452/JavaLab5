package org.example.controller;

import org.example.model.Shape;
import org.example.service.ShapeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {
    private static final Logger logger = LoggerFactory.getLogger(ShapeController.class);

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping
    public List<Shape> getAllShapes() {
        logger.info("GET request received for fetching all shapes");
        return shapeService.getAllShapes();
    }

    @PostMapping
    public Shape createShape(@RequestBody Shape shape) {
        logger.info("POST request received for creating a shape: {}", shape);
        return shapeService.saveShape(shape);
    }

    @GetMapping("/{id}")
    public Shape getShape(@PathVariable Long id) {
        logger.info("GET request received for fetching shape with id: {}", id);
        return shapeService.getShapeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteShape(@PathVariable Long id) {
        logger.info("DELETE request received for deleting shape with id: {}", id);
        shapeService.deleteShape(id);
    }
}
