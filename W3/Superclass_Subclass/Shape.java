public class Shape {

    private String color;
    private boolean filled;

    //No arg constructor
    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    //Constructor with parameters
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    //Getter and Setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "\nA Shape with color of " + color +
                " and " + (filled ? "filled" : "Not filled");
    }
}