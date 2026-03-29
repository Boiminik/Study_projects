package apps;

import entities.Circle;
import entities.Rectangle;

public class SimpleShapesDemo {
    public static void main(String[] args) {

        //application that manages Circles AND Rectangles

        Rectangle[] rects = new Rectangle[99];
        Circle[] circles = new Circle[99];


        //DRY


    }


    public static void moveAll(Rectangle[] rects, int dx, int dy){
        for (Rectangle r : rects)
            if(r!=null)
                r.move(dx, dy);
    }

    public static void moveAll(Circle[] rects, int dx, int dy){
        for (Circle r : rects)
            if(r!=null)
                r.move(dx, dy);
    }

}
