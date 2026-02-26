public class TestShape {
    
    public static void main(String[] args) {

        //Testing Shape
        System.out.println("\n======== Testing Shape ========");
        Shape s1 = new Shape();
        System.out.println(s1);

        //Testing Shape with parameters
        Shape s2 = new Shape("red", false);
        System.out.println(s2);

        //Testing Circle
        System.out.println("\n======== Testing Circle ========");
        Circle c1 = new Circle(7.0, "blue", true);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        //Testing Rectangle
        System.out.println("\n======== Testing Rectangle ========");
        Rectangle r1 = new Rectangle(4.0, 6.0, "yellow", false);
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        //Testing Square
        System.out.println("\n======== Testing Square ========");
        Square sq1 = new Square(5.0, "purple", true);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());
    }
}
