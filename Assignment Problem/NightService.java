import java.util.Locale;
import java.util.Scanner;

interface NightService {
    default double nightFare(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    private final int rate;

    Cab(int rate) {
        this.rate = rate;
    }

    final double fare(double km) {
        return Math.max(100, km * rate);
    }
}

class Mini extends Cab {
    Mini() { super(10); }
}

class Sedan extends Cab implements NightService {
    Sedan() { super(14); }
}

class SUV extends Cab implements NightService {
    SUV() { super(18); }
}

public class Main {
    static Cab createCab(String type) {
        switch (type) {
            case "MINI": return new Mini();
            case "SEDAN": return new Sedan();
            case "SUV": return new SUV();
            default: throw new IllegalArgumentException(type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = createCab(type);

            double fare = cab.fare(km);
            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(type + ": night service not available");
                    continue;
                }
                fare = ((NightService) cab).nightFare(fare);
            }

            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
