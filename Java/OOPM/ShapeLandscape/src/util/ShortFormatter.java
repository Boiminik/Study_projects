package util;

import entities.Shape;

public class ShortFormatter extends ShapeFormatter {
    @Override
    public String format(Shape s) {
        return String.format(s.getClass().getName());
    }
}
