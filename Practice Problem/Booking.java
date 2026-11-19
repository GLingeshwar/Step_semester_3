import java.util.Locale;
import java.util.Scanner;

abstract class Booking {
    private static final double BOOKING_FEE = 50;
    final double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    final double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2 * distance;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double baseFare() {
        return 1.5 * distance;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2500 + 4 * distance;
    }
}

public class Main {
    static Booking createBooking(String mode, double distance) {
        switch (mode) {
            case "BUS":
                return new Bus(distance);
            case "TRAIN":
                return new Train(distance);
            case "FLIGHT":
                return new Flight(distance);
            default:
                throw new IllegalArgumentException(mode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            Booking booking = createBooking(mode, sc.nextDouble());

            System.out.printf(Locale.US, "%s: %.2f%n", mode, booking.totalFare());
        }
    }
}
