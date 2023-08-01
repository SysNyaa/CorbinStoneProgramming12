public class Circle {
    double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double rad) {
        this.radius = rad;
    }

    public void setRadius(double rad) {
        radius = rad;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }

    public double getCircumference() {
        return 2*Math.PI*radius;
    }

    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ']';
    }
}
