class Stock {

    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            
            int profit = prices[i] - minPrice;

            
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = obj.maxProfit(prices);

        System.out.println(result);
    }
}
