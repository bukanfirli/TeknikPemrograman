public class Square extends Rectangle {

    //No arg constructor
    public Square() {
        super(1.0, 1.0);
    }

    //Constructor with parameters
    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    //Getter and Setter
    public double getSide() {
        return getWidth(); 
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    //Override to ensure width and length are always equal
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "\nA Square with side=" + getWidth() +
                ", which is a subclass of " + super.toString();
    }
}