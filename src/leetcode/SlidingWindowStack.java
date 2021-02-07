package leetcode;

import java.util.Stack;

public class SlidingWindowStack {
    public static void main(String[] args) {
//        int arr[] = {9, 7, 2, 4, 6, 8, 2, 1, 5};
//        int k = 3;
//
        SlidingWindowStack windowStack = new SlidingWindowStack();
//        windowStack.find(arr, k);
        int number = 1004;
        number += windowStack.convertFive(number);
        System.out.println(number);

    }

    private int convertFive(int number) {
        int result = 0;
        int decimalPlace = 1;

        if (number == 0) {
            result += (5 * decimalPlace);
        }

        while (number > 0) {
            if (number % 10 == 0) {
                result += (5*decimalPlace);
            }

            number /= 10;
            decimalPlace *= 10;
        }
        return result;
    }

    private void find(int[] arr, int k) {

        int n = arr.length;
        int[] max_upto = new int[n];

        // Update max_upto array similar to
        // finding next greater element
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.empty() && arr[s.peek()] < arr[i]) {
                max_upto[s.peek()] = i - 1;
                s.pop();
            }
            s.push(i);
        }
        while (!s.empty()) {
            max_upto[s.peek()] = n - 1;
            s.pop();
        }
        int j = 0;
        for (int i = 0; i <= n - k; i++) {

            // j < i is to check whether the
            // jth element is outside the window
            while (j < i || max_upto[j] < i + k - 1) {
                j++;
            }
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
