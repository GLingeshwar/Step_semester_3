public class QueueOrder {

    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(tokens1)); // 4

        
        int[] tokens2 = {1, 2, 2, 7};
        System.out.println(firstBreak(tokens2)); // -1

        
        int[] tokens3 = {10, 4, 6};
        System.out.println(firstBreak(tokens3)); // 1

        
        System.out.println(firstBreak(new int[]{}));  // -1
        System.out.println(firstBreak(new int[]{5})); // -1
    }
}
