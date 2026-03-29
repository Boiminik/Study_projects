package apps;

import entities.Circle;
import entities.Color;
import entities.Rectangle;
import entities.Shape;
import util.*;

import java.util.Scanner;

public class ShapeDemo {

    public static void main(String[] args) {
        Shape s = new Circle();//new entities.Shape();
        s.rotate(123);

        System.out.println(s.getString());

        Shape s2 = new Rectangle();
        Shape s3 = new Circle();

        Shape[] shapes = new Shape[3];
        shapes[1] = s2;
        shapes[0] = s3;
        shapes[2] = s;
        display(shapes);
        moveAll(shapes, 9, 7);
        display(shapes);
        System.out.println(totalArea(shapes));


        //open for extension, closed for modification

        Circle c = new Circle();
        c.setRadius(55);
        c.setLineStyle(2);
        c.setFillColor(new Color(5,3,9));

        Shape s4 = new Rectangle(c);
        display(new Shape[] {c, s4});

        System.out.println(new AreaComparator().compare(c, s4));

        ShapeComparator[] cmps = new ShapeComparator[]{new AreaComparator(),
                new CircumferenceComparator(),
                new DistanceComparator()};
        for (ShapeComparator cm: cmps)
            System.out.println(cm);
        Scanner sc = new Scanner(System.in);
        display(shapes);
        sort(shapes, cmps[sc.nextInt()]);
        display(shapes);


        display(shapes, new ShortFormatter());
        display(shapes, new CSVShapeFormat());


        System.out.println(s);

        display(filter(shapes, new LineStyleMatcher(0)));


        ConsoleScanable[] scanables = {new Color(), new Rectangle(), new Circle()};
        for (Shape sh: shapes){
            System.out.println("<" + sh.toSVG() + ">");
        }

    }

    public static Shape[] filter(Shape[] shapes, ShapeMatcher match){
        int cnt=0;
        for (Shape s: shapes){
            if (s!=null && match.matches(s))
                cnt++;
        }
        Shape[] filtered =  new Shape[cnt];

        int nextIdx=0;
        for (Shape s: shapes){
            if (s!=null && match.matches(s))
                filtered[nextIdx++] = s;
        }
        return filtered;
    }


    public static Shape[] filterByLineStyle(Shape[] shapes, int style){
        int cnt=0;
        for (Shape s: shapes){
            if (s!=null && s.getLineStyle() == style)
                cnt++;
        }

        Shape[] filtered =  new Shape[cnt];

        int nextIdx=0;
        for (Shape s: shapes){
            if (s!=null && s.getLineStyle() == style)
                filtered[nextIdx++] = s;
        }
        return filtered;
    }

    public static Shape[] filterByArea(Shape[] shapes, int minArea){
        int cnt=0;
        for (Shape s: shapes){
            if (s!=null && s.getArea()>=minArea)
                cnt++;
        }

        Shape[] filtered =  new Shape[cnt];

        int nextIdx=0;
        for (Shape s: shapes){
            if (s!=null && s.getArea()>=minArea)
                filtered[nextIdx++] = s;
        }
        return filtered;
    }







    public static void display(Shape[] shapes, ShapeFormatter fmt){
        System.out.println("---");

        for (Shape s : shapes)
            if (s!=null)
                System.out.println(fmt.format(s));
        System.out.println("---");
    }




    public static void sort(Shape[] shapes, ShapeComparator cmp){
        for (int i=0; i<shapes.length; i++)
            for (int j = 0; j < shapes.length-1; j++) {
                if (cmp.compare(shapes[j],shapes[j+1]) > 0 ) {
                    Shape tmp = shapes[j];
                    shapes[j] = shapes[j+1];
                    shapes[j+1] = tmp;
                }
            }
    }




    public static void sortByCircumference(Shape[] shapes){
        for (int i=0; i<shapes.length; i++)
            for (int j = 0; j < shapes.length-1; j++) {
                if (shapes[j].getCircumference() - shapes[j+1].getCircumference() > 0 ) {
                    Shape tmp = shapes[j];
                    shapes[j] = shapes[j+1];
                    shapes[j+1] = tmp;
                }
            }
    }

    public static void sortByArea(Shape[] shapes){
        for (int i=0; i<shapes.length; i++)
            for (int j = 0; j < shapes.length-1; j++) {
                if (shapes[j].getArea() - shapes[j+1].getArea() > 0 ) {
                    Shape tmp = shapes[j];
                    shapes[j] = shapes[j+1];
                    shapes[j+1] = tmp;
                }
            }
    }


    public static void bulkSetDim(Shape[] shapes,int w, int h){
        for (Shape s: shapes)
            if(s!=null)
                s.setDimensions(w,h);
    }



    public static int totalArea(Shape[] shapes)    {
        int sum=0;
        for (Shape s : shapes)
            if(s!=null)
                sum += s.getArea();

        return sum;
    }












    public static void display(Shape[] shapes){
        System.out.println("---");

        for (Shape s : shapes)
            if (s!=null)
                System.out.println(s.getString());
        System.out.println("---");
    }

    public static void moveAll(Shape[] shapes, int dx, int dy){
        for (Shape s : shapes)
            if(s!=null)
                s.move(dx, dy);
    }

}
