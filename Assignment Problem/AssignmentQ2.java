import java.util.Scanner;

public class Main {
    enum Vehicle {
        BIKE {
            int charge(int hours) {
                return 10 * hours;
            }
        },
        CAR {
            int charge(int hours) {
                return 30 + 20 * (hours - 1);
            }
        },
        TRUCK {
            int charge(int hours) {
                return Math.max(100, 50 * hours);
            }
        };

        abstract int charge(int hours);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;

        for (int i = 0; i < n; i++) {
            Vehicle vehicle = Vehicle.valueOf(sc.next());
            int charge = vehicle.charge(sc.nextInt());

            System.out.println(vehicle + ": " + charge + ".00");
            total += charge;
        }

        System.out.println("Total: " + total + ".00");
    }
}
