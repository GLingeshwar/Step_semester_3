import java.util.Locale;
import java.util.Scanner;

abstract class LibraryItem {
    final String title;
    final int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return 2.0 * daysLate;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return Math.min(5.0 * daysLate, 50);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate;
    }
}

public class Main {
    static LibraryItem readItem(Scanner sc) {
        String type = sc.next();
        String title = sc.next();
        int days = sc.nextInt();

        switch (type) {
            case "BOOK":
                return new Book(title, days);
            case "DVD":
                return new DVD(title, days);
            case "MAGAZINE":
                return new Magazine(title, days);
            default:
                throw new IllegalArgumentException(type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            LibraryItem item = readItem(sc);
            double fine = item.fine();

            System.out.printf(Locale.US, "%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
