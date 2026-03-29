package apps;

import entities.Color;

public class ColorDemo {
    public static void main(String[] args) {
        Color c = new Color();
        c.setR(114);
        c.setG(210);
        c.setB(190);
        System.out.println(c.getString());

        Color hotpink = new Color();
        hotpink.setR(255);
        hotpink.setG(105);
        hotpink.setB(180);
        System.out.println(hotpink.getString());


        hotpink.toGrayValue();
        System.out.println(hotpink.getString());


        c = hotpink;
        c.setR(0);
        System.out.println(hotpink.getString());

        hotpink.toGrayValue();
        System.out.println(hotpink.getString());


        //get r g b values as array
        for (int n: hotpink.getRGB())
            System.out.print(n);
        System.out.println();

        Color gackibraun = new Color(); //aka 'schießmichtot'
        gackibraun.setR(59);
        gackibraun.setG(28);
        gackibraun.setB(27);
        System.out.println(gackibraun.getString());
        gackibraun.invert();
        System.out.println(gackibraun.getString());

        for (int i = 0; i < 10; i++) {
            gackibraun.brighter();
            System.out.println(gackibraun.getString());
        }

        Color c2 = new Color(114,210,190);
        Color c3 = new Color(c2);
        System.out.println(c2.getString() + c2.hashCode());
        System.out.println(c3.getString() + c3.hashCode());
        System.out.print(c2 == c3);
    }
}
