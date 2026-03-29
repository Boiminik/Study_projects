package apps;

import entities.Color;
import entities.Rectangle;

public class RectangleDemo {

    public static void main(String[] args){
        Rectangle r = new Rectangle();
        System.out.println(r.getPosX());

        //r.posX = -6;

        //r.posY = 0;


        //r.rotation = -270;
        r.setRotation(-270);

        r.getWidth();
        r.setWidth(25);

        r.rotate(800);
        System.out.println(r.getArea());


        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle();
        Rectangle[] rects = new Rectangle[10];
        rects[0] = r;
        rects[1] = r2;
     /*   rects[2] = new entities.Rectangle(12,15);
        rects[4] = new entities.Rectangle(12,15, -10, 20);
        rects[3] = r3;
        new entities.Rectangle(r);
        entities.Rectangle copy = r.shallowCopy();*/
        r.getFillColor().darker();
        r3.move(-50,50);
        r2.setLineStyle(3);
        r.setLineWidth(10);
        r3.setFillColor(new Color(124, 198, 1));
        display(rects);

        int totalArea = totalArea(rects);
        moveAll(rects, 20, 90);

        display(rects);


    }

    public static void moveAll(Rectangle[] rects, int dx, int dy){
        for (Rectangle r : rects)
            if(r!=null)
                r.move(dx, dy);
    }

    public static int totalArea(Rectangle[] rects)    {
        int sum=0;
        for (Rectangle r : rects)
            if(r!=null)
                sum += r.getArea();

        return sum;
    }

    public static void display(Rectangle[] rects){
        System.out.println("---");

        for (Rectangle r : rects)
            if (r!=null)
                System.out.println(r.getString());
        System.out.println("---");
    }


}
