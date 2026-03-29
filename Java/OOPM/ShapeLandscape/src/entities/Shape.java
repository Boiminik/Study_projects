package entities;

import util.ConsoleScanable;
import util.ToSVG;

import java.util.Scanner;

public abstract class Shape implements ConsoleScanable, ToSVG {
    private int posX; //in pt
    private int posY; //in pt
    private double rotation; //in degrees, [0, 360)

    private int lineWidth = 1; //in pt >=0
    private  Color lineColor = new Color(0,0,0);
    private Color fillColor = new Color(255,255,255); //null= no fillColor;
    private int lineStyle = 0; //0..solid, 1..dashed, 2..dotted, 3..dash-dotted

    public String toSVG(){
        String svgString ="";
        svgString += "cx=\"" + posX + "\"";
        svgString += "cy=\"" + posY + "\"";
        svgString += "stroke=\"" + lineColor.getString() + "\"";
        svgString += "stroke-width=\"" + lineWidth + "\"";
        svgString += "fill=\"" + fillColor.getString() + "\"";
        return svgString;


    }

    public abstract void setDimensions(int w, int h);

    public Shape(Shape original){
        this.posY = original.posY;
        this.posX = original.posX;
        this.rotation = original.rotation;
        //this.lineColor = original.lineColor; //shallow copy
        this.lineColor = new Color(original.lineColor); //deep copy
        this.fillColor = new Color(original.fillColor); //deep copy
        this.lineStyle = original.lineStyle;

    }

    public Shape(){

    }

    public Shape(int x, int y){
        posX = x;
        posY = y;

    }



    public String getString(){
        return String.format(

                        " (%03d | %03d) |" +
                        "%5.1f° |" +
                        " style: %s %s %12s %3d |"+
                        " A = %5d, U = %5d",

                posX, posY,
                rotation,
                lineColor.getString(), fillColor.getString(),
                getLineStyleString(),
                lineWidth,
                getArea(), getCircumference()
        );
    }

    private String getLineStyleString() {
        //0..solid, 1..dashed, 2..dotted, 3..dash-dotted
        String[] styles = {"solid", "dashed", "dotted", "dash-dotted"};
        return styles[lineStyle];
    }


    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        if(lineWidth>=0)
            this.lineWidth = lineWidth;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        if (lineColor!=null)
            this.lineColor = lineColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public int getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(int lineStyle) {
        if(lineStyle>=0 && lineStyle<=3)
            this.lineStyle = lineStyle;
    }

    public void move(int x, int y){
        posX += x;
        posY += y;
    }

    public void rotate(double a   ){
        rotation = (( rotation + a ) %360 + 360 )%360;
    }

    public double getRotation() {
        return rotation;
    }

    //first simple setter
    public void setRotation(double r){
        if(r>=0 && r<360)
            rotation = r;
    }

    //first simple getter
    public int getPosX(){
        return posX;
    }

    public int[] getPosition(){
        return new int[]{posX, posY};
    }


    public abstract int getArea();

    public abstract int getCircumference();
    @Override
    public void scan(Scanner sc) {
        lineColor.scan(sc);
        fillColor.scan(sc);
        //Add smart code
        setLineWidth(sc.nextInt());
        //and so on
    }

    }
