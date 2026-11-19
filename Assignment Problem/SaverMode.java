import java.util.Locale;
import java.util.Scanner;

interface SaverMode {
    default double saverUnits(double units) {
        return units * 0.75;
    }
}

abstract class Appliance {
    private final int watts;

    Appliance(int watts) {
        this.watts = watts;
    }

    final double units(double hours) {
        return watts * hours / 1000;
    }
}

class Fridge extends Appliance {
    Fridge() { super(150); }
}

class AC extends Appliance implements SaverMode {
    AC() { super(1500); }
}

class TV extends Appliance {
    TV() { super(100); }
}

class Washer extends Appliance implements SaverMode {
    Washer() { super(500); }
}

public class Main {
    static Appliance createAppliance(String type) {
        switch (type) {
            case "FRIDGE": return new Fridge();
            case "AC": return new AC();
            case "TV": return new TV();
            case "WASHER": return new Washer();
            default: throw new IllegalArgumentException(type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] fields = sc.nextLine().trim().split("\\s+");
            String type = fields[0];
            double hours = Double.parseDouble(fields[1]);
            boolean saver = fields.length == 3 && fields[2].equals("SAVER");

            Appliance appliance = createAppliance(type);
            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.units(hours);
            if (saver) {
                units = ((SaverMode) appliance).saverUnits(units);
            }

            double cost = units * 8;
            totalCost += cost;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
