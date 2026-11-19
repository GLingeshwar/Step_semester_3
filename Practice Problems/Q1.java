import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum PaymentType {
        CARD("1.02"),
        WALLET("1.01"),
        BANKTRANSFER("1.00");

        private final BigDecimal multiplier;

        PaymentType(String multiplier) {
            this.multiplier = new BigDecimal(multiplier);
        }

        BigDecimal finalAmount(BigDecimal amount) {
            return amount.multiply(multiplier);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        BigDecimal total = BigDecimal.ZERO;

        for (int i = 0; i < n; i++) {
            PaymentType type = PaymentType.valueOf(sc.next());
            BigDecimal amount = type.finalAmount(sc.nextBigDecimal());

            System.out.printf(Locale.US, "%s: %.2f%n", type, amount);
            total = total.add(amount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
