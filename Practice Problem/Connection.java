import java.util.Locale;
import java.util.Scanner;

abstract class Connection {
    final double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double bill() {
        if (units <= 100) {
            return units * 5;
        }
        return 500 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6, 1000);
    }
}

public class Main {
    static Connection createConnection(String type, double units) {
        switch (type) {
            case "HOME":
                return new Home(units);
            case "SHOP":
                return new Shop(units);
            case "FACTORY":
                return new Factory(units);
            default:
                throw new IllegalArgumentException(type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            Connection connection = createConnection(type, sc.nextDouble());
            double bill = connection.bill();

            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
