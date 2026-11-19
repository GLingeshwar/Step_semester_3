import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    final String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
}

class Circle extends Plot {
    final double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    final double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Plot {
    final double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class Main {
    static Plot readPlot(String shape, Scanner sc) {
        String owner = sc.next();

        switch (shape) {
            case "CIRCLE":
                return new Circle(owner, sc.nextDouble());
            case "RECTANGLE":
                return new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            case "TRIANGLE":
                return new Triangle(owner, sc.nextDouble(), sc.nextDouble());
            default:
                throw new IllegalArgumentException(shape);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            Plot plot = readPlot(shape, sc);
            double area = plot.area();

            System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.owner, shape, area);
            total += area;
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
