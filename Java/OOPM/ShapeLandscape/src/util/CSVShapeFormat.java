package util;

import entities.Shape;

public class CSVShapeFormat extends ShapeFormatter {
    @Override
    public String format(Shape s) {
        return String.format("%d,%d", s.getPosition()[0], s.getPosition()[1]); //and many more fields
    }
}
