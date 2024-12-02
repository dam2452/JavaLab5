package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeDescriber {
    private static final Logger logger = LoggerFactory.getLogger(ShapeDescriber.class);

    public void describe(Shape shape) {
        if (shape == null) {
            logger.warn("Shape is null. Cannot describe.");
            return;
        }

        logger.info("Shape Type: {}", shape.getClass().getSimpleName());
        logger.info("Color: {}", shape.getColorDescription());
        logger.info("Area: {}", shape.getArea());
        logger.info("Perimeter: {}", shape.getPerimeter());
    }
}
