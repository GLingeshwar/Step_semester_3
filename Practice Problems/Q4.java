import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {
    enum QuestionType {
        MCQ, TF,
        ESSAY {
            @Override
            double grade(String correct, String answer, int points) {
                String response = answer.toLowerCase(Locale.ROOT);
                Set<String> matches = new HashSet<>();

                for (String word : correct.split(",")) {
                    String keyword = word.trim().toLowerCase(Locale.ROOT);

                    if (!keyword.isEmpty() && response.contains(keyword)) {
                        matches.add(keyword);
                    }
                }

                if (matches.size() >= 2) return points * 0.75;
                if (matches.size() == 1) return points * 0.50;
                return 0;
            }
        };

        double grade(String correct, String answer, int points) {
            return correct.equals(answer) ? points : 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] fields = sc.nextLine().split("\"");
            QuestionType type = QuestionType.valueOf(fields[0].trim());

            
            String correct = fields[3];
            String answer = fields[5];
            int points = Integer.parseInt(fields[6].trim());

            double score = type.grade(correct, answer, points);
            System.out.printf(Locale.US, "%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
