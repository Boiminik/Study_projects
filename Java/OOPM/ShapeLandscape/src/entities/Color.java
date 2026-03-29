package entities;

import util.ConsoleScanable;

import java.util.Scanner;

public class Color implements ConsoleScanable{
    private int r = 0;
    private int g = 0;
    private int b = 0; //all [0, 255] default: black

    //copy constructor
    public Color(Color o){
        this.r = o.r;
        this.g = o.g;
        this.b = o.b;
    }

    //custom constructor
    public Color(int r, int g, int b){
        setR(r);
        setG(g);
        setB(b);
    }

    //shade of gray constructor
    public Color(int grayLevel){
        setR(grayLevel);
        setG(grayLevel);
        setB(grayLevel);
    }



    //standard constructor
    public Color(){

    }


    public void darker(){
        //decrease all by 5 (if possible)
        setR(r-5);
        setG(g-5);
        setB(b-5);
    }

    public void brighter(){
        //increase all by 5 (if possible)
        setR(r+5);
        setG(g+5);
        setB(b+5);
    }

    public void invert(){
        //r -> 255-r, etc
        this.r = 255 - this.r;
        this.g = 255 - this.g;
        this.b = 255 - this.b;

    }

    public int[] getRGB(){
        return new int[]{r,g,b};
    }


    public void toGrayValue(){
        r = g = b = (r + g + b)/3;
    }

    public void setR(int r) {
        this.r = Math.min(Math.max(0,r),255);
    }

    public void setG(int g) {
       if(g<0)
           this.g=0;
       else if(g>255)
           this.g = 255;
       else
           this.g = g;
    }

    public void setB(int b) {
        this.b = Math.min(Math.max(0,b),255);
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public String getString(){
        //hex string
        return String.format("#%02X%02X%02X", r, g, b);
    }

    @Override
    public void scan(Scanner sc) {
        System.out.println("enter red, green, blue");
        setR(sc.nextInt());
        setG(sc.nextInt());
        setB(sc.nextInt());
    }
}
