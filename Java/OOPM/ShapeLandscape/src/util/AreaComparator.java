package util;

import entities.Shape;

public class AreaComparator extends ShapeComparator{
    @Override
    public int compare(Shape s1, Shape s2) {
        return s2.getArea() - s1.getArea();
    }
}
