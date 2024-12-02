package service;

import model.Shape;
import model.ShapeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeService {
    private static final Logger logger = LoggerFactory.getLogger(ShapeService.class);

    private final ShapeRepository shapeRepository;

    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public Shape saveShape(Shape shape) {
        logger.info("Saving shape: {}", shape);
        return shapeRepository.save(shape);
    }

    public List<Shape> getAllShapes() {
        logger.info("Fetching all shapes");
        return shapeRepository.findAll();
    }

    public Shape getShapeById(Long id) {
        logger.info("Fetching shape with id: {}", id);
        return shapeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Shape not found with id: {}", id);
                    return new RuntimeException("Shape not found");
                });
    }

    public void deleteShape(Long id) {
        logger.info("Deleting shape with id: {}", id);
        shapeRepository.deleteById(id);
    }
}
