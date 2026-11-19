import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("[\\s,\\[\\]]+");

        ArrayList<Integer> numbers = new ArrayList<>();
        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }

        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            int temp = numbers.get(left);
            numbers.set(left, numbers.get(right));
            numbers.set(right, temp);
            left++;
            right--;
        }

        System.out.println(numbers);
    }
}
