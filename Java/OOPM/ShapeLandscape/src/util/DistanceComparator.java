package util;

import entities.Shape;

public class DistanceComparator extends ShapeComparator {
    @Override
    public int compare(Shape s1, Shape s2) {
        int[] d1 = s1.getPosition();
        int[] d2 = s2.getPosition();
        return d1[0]*d1[0] + d1[1]*d1[1] - d2[0]*d2[0] + d2[1]*d2[1];
    }
}
