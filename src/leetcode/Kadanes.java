package leetcode;

public class Kadanes {

    public static void main(String[] args) {
        int[] array = { 1, -2, 3, 3, 2, 5, -14, 10, 12, 3, -10 };

        Kadanes kadanes = new Kadanes();
        int maximumSum = kadanes.findMaximum(array);
        System.out.println(maximumSum);
    }

    private int findMaximum(int[] array) {
        int count = 0;
        int max_value = 0;
        for (int value : array) {
            count = Math.max(count, 0) + value;
            max_value = Math.max(max_value, count);
        }
        return max_value;
    }
}
