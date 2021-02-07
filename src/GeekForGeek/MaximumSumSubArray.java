package GeekForGeek;

public class MaximumSumSubArray {

    public static void main(String[] arguments) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

    private static int maxSum(int[] arr, int numberOfElements, int subArrayNumber) {
        int windowSum;
        int maxSum = 0;
        for (int i = 0; i < subArrayNumber; i++) {
            maxSum += arr[i];
        }

        windowSum = maxSum;

        for (int i = subArrayNumber; i < numberOfElements; i++) {
            windowSum = windowSum - arr[i-subArrayNumber]+arr[i];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }


}
