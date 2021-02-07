package leetcode;

public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 0, 20, 4, 2, 10, 23};
        int k = 4;

        SlidingWindow slidingWindow = new SlidingWindow();
        System.out.println(slidingWindow.findMaxSum(arr, k));
    }

    private int findMaxSum(int[] arr, int k) {
        int current_sum = 0;
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            current_sum += arr[i];
            max_sum = current_sum;
        }

        for (int i = 1; i < arr.length; i++) {
            if ((i - 1 + k) < arr.length) {
                current_sum = current_sum - arr[i - 1] + arr[i - 1 + k];
                max_sum = Math.max(current_sum, max_sum);
            }
        }

        return max_sum;
    }
}
