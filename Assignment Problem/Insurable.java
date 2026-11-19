import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    default double insurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

abstract class Parcel {
    final double weight;
    final double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double charge();
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 80 + 15 * weight;
    }
}

class Fragile extends Standard implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return super.charge() + 50;
    }
}

public class Main {
    static Parcel createParcel(String type, double weight, double value) {
        switch (type) {
            case "STANDARD": return new Standard(weight, value);
            case "EXPRESS": return new Express(weight, value);
            case "FRAGILE": return new Fragile(weight, value);
            default: throw new IllegalArgumentException(type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel = createParcel(type, weight, value);

            double charge = parcel.charge();
            double insurance = 0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).insurance(parcel.declaredValue);
            }

            double total = charge + insurance;
            grandTotal += total;
            System.out.printf(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
