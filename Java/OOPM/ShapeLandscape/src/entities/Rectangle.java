package entities;

public  class Rectangle extends Shape {

    private int width=10; //in pt (0, oo)
    private int height =10; //in pt >0

    public Rectangle(Shape o){
        super(o);
    }

    public String toSVG(){
        String svgString="rect";
        svgString += "width\"" + width + "\"";
        svgString += "height\"" + height + "\"";
        svgString += super.toSVG();
        return svgString;
    }


    public Rectangle(Rectangle original){
        super(original);
        this.width = original.width;
        this.height = original.height;
    }

    public Rectangle(){
        super();
        width = 10;
        height = 10;
    }

    public Rectangle(int w, int h, int x, int y) {
        super(x,y);
        setWidth(w);
        setHeight(h);
    }
    @Override
    public void setDimensions(int w, int h) {
      setWidth(w);
      setHeight(h);
    }


 /*
    //copy constructor
    public entities.Rectangle(entities.Rectangle original){

        this.posY = original.posY;
        this.posX = original.posX;
        this.rotation = original.rotation;
        this.width = original.width;
        this.height = original.height;
        //this.lineColor = original.lineColor; //shallow copy
        this.lineColor = new entities.Color(original.lineColor); //deep copy
        this.fillColor = new entities.Color(original.fillColor); //deep copy
        this.lineStyle = original.lineStyle;



    }

    public entities.Rectangle(){

    }

    public entities.Rectangle(int w, int h){
        setWidth(w);
        setHeight(h);
    }

    public entities.Rectangle(int w, int h, int x, int y) {

        this(w,h);
        posX = x;
        posY = y;


    }

    public entities.Rectangle deepCopy(){
        //not implemented
        return null;
    }


    public entities.Rectangle shallowCopy(){
        entities.Rectangle newObject = new entities.Rectangle();
        newObject.posY = this.posY;
        newObject.posX = this.posX;
        newObject.rotation = this.rotation;
        newObject.width = this.width;
        newObject.height = this.height;
        newObject.lineColor = this.lineColor; //shallow copy
        newObject.fillColor = this.fillColor;
        newObject.lineStyle = this.lineStyle;
        return newObject;
    }
    */





    public int getArea(){

        return width * height;
    }

    public int getCircumference(){
        //umfang
        return (width + height ) *2;
    }



    public int getWidth(){

        return width;
    }
    public void setWidth(int w){
        if (w>0)
            width = w;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int h){
        if (h>0)
            height = h;
    }

    @Override
    public String getString(){
        return String.format(
                "%s" +
                        "%3d x %3d | entities.Rectangle"
                        ,
                super.getString(),
                width, height

        );
    }


}
