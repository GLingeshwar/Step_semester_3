import java.util.Locale;
import java.util.Scanner;

abstract class Ticket {
    private static final int CONVENIENCE_FEE = 20;
    private final int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract int seatPrice();

    final double amount() {
        return (double) count * (seatPrice() + CONVENIENCE_FEE);
    }
}

class Regular extends Ticket {
    Regular(int count) { super(count); }
    int seatPrice() { return 150; }
}

class Premium extends Ticket {
    Premium(int count) { super(count); }
    int seatPrice() { return 250; }
}

class Recliner extends Ticket {
    Recliner(int count) { super(count); }
    int seatPrice() { return 400; }
}

public class Main {
    static Ticket createTicket(String seat, int count) {
        switch (seat) {
            case "REGULAR": return new Regular(count);
            case "PREMIUM": return new Premium(count);
            case "RECLINER": return new Recliner(count);
            default: throw new IllegalArgumentException(seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            Ticket ticket = createTicket(seat, sc.nextInt());
            double amount = ticket.amount();

            System.out.printf(Locale.US, "%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
