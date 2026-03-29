package util;

import entities.Shape;

public abstract class ShapeComparator {

    /**
     * returns a measure of the distance between two shapes
     *  returns zero if the two shapes are equal
     *
     * @param s1 one shape to compare
     * @param s2 the shape to compare to
     * @return the distance
     */
    public abstract int compare(Shape s1, Shape s2);
}
