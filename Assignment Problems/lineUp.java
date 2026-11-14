import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int pass = 1;

        while (true) {
            boolean swapped = false;

            for (int j = 0; j < heights.length - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));

            if (!swapped) {
                break;
            }

            pass++;
        }
    }

    public static void main(String[] args) {
        
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        System.out.println();

        
        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);

        System.out.println();

        
        int[] heights3 = {6, 3, 8, 2, 5};
        lineUp(heights3);
    }
}

