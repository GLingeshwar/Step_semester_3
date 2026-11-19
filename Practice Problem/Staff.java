import java.util.Locale;
import java.util.Scanner;

abstract class Staff {
    final String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {
    final double weeklySalary;

    FullTime(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double pay() {
        return weeklySalary;
    }
}

class Hourly extends Staff {
    final double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        double regularHours = Math.min(hours, 40);
        double overtimeHours = Math.max(hours - 40, 0);
        return regularHours * rate + overtimeHours * 1.5 * rate;
    }
}

class Intern extends Staff {
    final double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class Main {
    static Staff readStaff(Scanner sc) {
        String type = sc.next();
        String name = sc.next();

        switch (type) {
            case "FULLTIME":
                return new FullTime(name, sc.nextDouble());
            case "HOURLY":
                return new Hourly(name, sc.nextDouble(), sc.nextDouble());
            case "INTERN":
                return new Intern(name, sc.nextDouble());
            default:
                throw new IllegalArgumentException(type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            Staff staff = readStaff(sc);
            double pay = staff.pay();

            System.out.printf(Locale.US, "%s: %.2f%n", staff.name, pay);
            total += pay;
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
