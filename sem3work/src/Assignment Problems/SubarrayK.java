import java.util.HashMap;

class SubarrayK {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 occurs once before starting
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int required = currentSum - k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = obj.subarraySum(nums, k);

        System.out.println(result);
    }
}
