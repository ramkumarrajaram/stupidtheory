package GeekForGeek;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubArrays {

    public static void main(String[] some) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int subArraySize = 4;

        findMaximumInASubArray(arr, subArraySize);
    }

    private static void findMaximumInASubArray(int[] arr, int subArraySize) {
        int arrayLength = arr.length;
        Deque<Integer> Qi = new LinkedList<Integer>();

        Arrays.sort(arr);

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < subArraySize; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < arrayLength; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - subArraySize)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
}
