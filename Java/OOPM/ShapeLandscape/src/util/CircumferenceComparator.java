package util;

import entities.Shape;

public class CircumferenceComparator extends ShapeComparator {
    @Override
    public int compare(Shape s1, Shape s2) {
        return s2.getCircumference() - s1.getCircumference();
    }
}
