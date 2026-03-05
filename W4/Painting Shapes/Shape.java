public abstract class Shape
{
    protected String shapeName;

    // constructor
    public Shape(String name)
    {
        shapeName = name;
    }

    // abstract method
    public abstract double area();

    // toString method
    @Override
    public String toString()
    {
        return shapeName;
    }
}