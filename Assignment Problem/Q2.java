public class Main {
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        int[][] samples = {
            {1, 1, 0, 1, 1, 1, 0, 1},
            {0, 0, 0}
        };

        for (int[] days : samples) {
            int[] result = attendanceSummary(days);
            System.out.printf("Present: %d, Longest streak: %d%n", result[0], result[1]);
        }
    }
}
