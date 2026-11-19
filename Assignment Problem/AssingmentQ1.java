import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum Customer {
        STUDENT {
            BigDecimal finalAmount(BigDecimal bill) {
                return bill.multiply(new BigDecimal("0.90"));
            }
        },
        STAFF {
            BigDecimal finalAmount(BigDecimal bill) {
                return bill.multiply(new BigDecimal("0.95"));
            }
        },
        GUEST {
            BigDecimal finalAmount(BigDecimal bill) {
                return bill.add(BigDecimal.TEN);
            }
        };

        abstract BigDecimal finalAmount(BigDecimal bill);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        BigDecimal total = BigDecimal.ZERO;

        for (int i = 0; i < n; i++) {
            Customer customer = Customer.valueOf(sc.next());
            BigDecimal amount = customer.finalAmount(sc.nextBigDecimal());

            System.out.printf(Locale.US, "%s: %.2f%n", customer, amount);
            total = total.add(amount);
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
