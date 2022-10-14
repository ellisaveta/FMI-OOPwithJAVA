package rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(); //1 1 yellow

        Rectangle.setColor("red"); // static -> changes for every object
        //System.out.println(rectangle.toString());
        System.out.println(rectangle);

        Rectangle rectangle1 = new Rectangle(1.3274, 4.732);
        System.out.println(rectangle1);

        rectangle1.setHeight(3.5);
        rectangle1.setWidth(4);

        System.out.printf("Area: %.3f, Perimeter: %.3f\n",
                rectangle1.getArea(), rectangle.getPerimeter());
    }
}
