import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum EmployeeType {
        FULLTIME {
            BigDecimal bonus(BigDecimal salary) {
                return salary.multiply(new BigDecimal("0.10"));
            }
        },
        PARTTIME {
            BigDecimal bonus(BigDecimal salary) {
                return salary.multiply(new BigDecimal("0.05"));
            }
        },
        INTERN {
            BigDecimal bonus(BigDecimal salary) {
                return BigDecimal.valueOf(2000);
            }
        };

        abstract BigDecimal bonus(BigDecimal salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        BigDecimal total = BigDecimal.ZERO;

        for (int i = 0; i < n; i++) {
            EmployeeType type = EmployeeType.valueOf(sc.next());
            String name = sc.next();
            BigDecimal salary = sc.nextBigDecimal();
            BigDecimal bonus = type.bonus(salary);

            System.out.printf(Locale.US, "%s: %.2f%n", name, bonus);
            total = total.add(bonus);
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
