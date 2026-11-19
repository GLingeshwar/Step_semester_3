import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    enum ItemType {
        BOOK(14), DVD(7), MAGAZINE(3);

        private final int days;

        ItemType(int days) {
            this.days = days;
        }

        LocalDate dueDate(LocalDate borrowedOn) {
            return borrowedOn.plusDays(days);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LocalDate borrowedOn = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            ItemType type = ItemType.valueOf(sc.next());
            String title = sc.nextLine().trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            System.out.println(title + ": " + type.dueDate(borrowedOn));
        }
    }
}
