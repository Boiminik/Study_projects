package util;

import entities.Shape;

public class LineStyleMatcher extends ShapeMatcher{
    private int style;
    public LineStyleMatcher(int style){
        this.style = style;
    }

    @Override
    public boolean matches(Shape s) {
        return s.getLineStyle()==style;
    }
}
