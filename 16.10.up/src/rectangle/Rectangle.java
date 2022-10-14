package rectangle;

public class Rectangle {
    private double width;
    private double height;
    private static String color;

    public Rectangle() {
        setWidth(1);
        setHeight(1);
        setColor("yellow");
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public static String getColor() {
        return color;
    }

    public void setWidth(double width) {
        if(width <= 0) {
            this.width = 1;
        }
        else {
            this.width = width;
        }
    }

    public void setHeight(double height) {
        if(height <= 0) {
            this.height = 1;
        }
        else {
            this.height = height;
        }
    }

    public static void setColor(String color) {
        if(color == null) {
            Rectangle.color = "yellow";
        }
        else{
            Rectangle.color = color;
        }
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Width: %.2f, Height: %.2f, Color: %s",
                width, height, color);
    }
}
