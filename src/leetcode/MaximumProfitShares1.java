package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumProfitShares1 {
    public static void main(String[] args) {
//        int[] stocks = {7,1,5,3,6,4};
        int[] stocks = {7,6,4,3,1};
       // int[] stocks = {3, 3};

        MaximumProfitShares1 profit =  new MaximumProfitShares1();

        System.out.println(profit.getMaxProfit(stocks));
    }
    private int getMaxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;

        int maximum_profit = 0;

        for (int i = 0; i < prices.length; i++) {
            minimum = Math.min(minimum, prices[i]);
            maximum_profit = Math.max(maximum_profit, prices[i] - minimum);
        }

        return maximum_profit;
    }

//    private int getMaxProfit(int[] prices) {
//        Map<Integer, Integer> stockMap = new HashMap<>();
//
//        for (int i = 0; i <prices.length; i++) {
//            stockMap.put(prices[i], i);
//        }
//
//        Integer[] keys = stockMap.keySet().toArray(new Integer[prices.length]);
//        int i =0, j = keys.length - 1;
//        while(i < j) {
//            if(stockMap.get(keys[i]) < stockMap.get(keys[j])) {
//                return keys[j] - keys[i];
//            } else {
//                j--;
//            }
//        }
//
//        return 0;
//    }
}
