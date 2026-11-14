import java.util.*;

interface PaymentMode {
    double processPayment(double amount);
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount * 1.02;
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PaymentMode p[] = new PaymentMode[n];

        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double amount = sc.nextDouble();

            if (mode.equals("Cash"))
                p[i] = new CashPayment();
            else if (mode.equals("Card"))
                p[i] = new CardPayment();
            else
                p[i] = new UpiPayment();

            double processed = p[i].processPayment(amount);
            double fee = processed - amount;

            System.out.println(mode + ": amount " + amount +
                ", fee " + fee + ", processed " + processed);

            total += processed;
        }

        System.out.println("Total Amount Processed: " + total);
    }
}
