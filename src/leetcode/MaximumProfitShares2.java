package leetcode;

public class MaximumProfitShares2 {
    public static void main(String[] args) {
        //int[] stocks = {7,1,5,3,6,4};
        int[] stocks = {1, 2, 3, 4, 5};
        //int[] stocks = {7,6,4,3,1};
        //int[] stocks = {3, 3};

        MaximumProfitShares2 profit = new MaximumProfitShares2();

        System.out.println(profit.getMaxProfit(stocks));
    }

    private int getMaxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}