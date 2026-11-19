import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    enum Plan {
        BASIC(30), STANDARD(90), PREMIUM(365);

        private final int days;

        Plan(int days) {
            this.days = days;
        }

        LocalDate renewalDate(LocalDate startDate) {
            return startDate.plusDays(days);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Plan plan = Plan.valueOf(sc.next());
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            System.out.println(name + ": " + plan.renewalDate(startDate));
        }
    }
}
