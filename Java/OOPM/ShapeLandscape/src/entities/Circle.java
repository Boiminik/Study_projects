package entities;

public  class Circle extends Shape {

    private int radius = 5; //>0


    //copy constructor
    /*
    public entities.Circle(entities.Circle original){
        this.posY = original.posY;
        this.posX = original.posX;
        this.rotation = original.rotation;
        this.radius = original.radius;

        //this.lineColor = original.lineColor; //shallow copy
        this.lineColor = new entities.Color(original.lineColor); //deep copy
        this.fillColor = new entities.Color(original.fillColor); //deep copy
        this.lineStyle = original.lineStyle;
    }

    public entities.Circle(){

    }
    public entities.Circle(int r){
        setRadius(r);
    }


    public entities.Circle(int r, int x, int y) {
        this(r);
        posX = x;
        posY = y;
    }
*/

    @Override
    public void setDimensions(int w, int h) {
        setRadius((Math.min(w,h))); //or something meaningful
    }

    @Override
    public String getString(){
        return String.format(
                "%s" +
                        "%3d  | entities.Circle"
                ,
                super.getString(),
                radius

        );
    }

    public String toSVG(){
        String svgString = "circle";
        svgString += "r=\"" + radius + "\"";
        svgString += super.toSVG();
        return svgString;
    }





    public int getArea(){

        return (int) (radius * radius * Math.PI);
    }

    public int getCircumference(){
        //umfang
        return (int) (radius *2 * Math.PI);
    }



    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius>0)
        this.radius = radius;
    }



}
