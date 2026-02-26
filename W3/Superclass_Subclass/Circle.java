public class Circle extends Shape {

    private double radius;

    //No arg constructor
    public Circle() {
        super();
        this.radius = 1.0;
    }

    //Constructor with parameters
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    //Getter and Setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "\nA Circle with radius=" + radius +
                ", which is a subclass of " + super.toString();
    }
}