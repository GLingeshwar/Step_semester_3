import java.util.Locale;
import java.util.Scanner;

interface BusUser {
    int TRANSPORT_FEE = 12000;
}

abstract class Student {
    static final int NORMAL_TUITION = 40000;
    final String name;

    Student(String name) {
        this.name = name;
    }

    int tuition() {
        return NORMAL_TUITION;
    }

    int hostelFee() {
        return 0;
    }

    final int totalFee() {
        int fee = tuition() + hostelFee();
        if (this instanceof BusUser) {
            fee += BusUser.TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    int hostelFee() {
        return 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    int tuition() {
        return NORMAL_TUITION / 2;
    }
}

public class Main {
    static Student createStudent(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new Scholar(name);
            default: throw new IllegalArgumentException(type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = createStudent(type, name);
            double fee = student.totalFee();

            System.out.printf(Locale.US, "%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
