package leetcode;


import java.util.Arrays;
import java.util.HashMap;

class Median {
    public static void main(String[] args) {
        int[] A = {100};
        int[] B = {1, 5, 8, 10, 20};
        int[] C = {1,21,3,14,5,60,7,6};

   //     System.out.println(getMedian(A, B));
        int[] sum = findSum(C, 81);
        System.out.println(sum[0] + " " + sum[1]);
    }
    public static int getMedian(int array1[], int array2[]) {
        // Write your code here
        int[] newArray = new int[array1.length + array2.length];
        int firstPointer = array1.length - 1, secondPointer = array2.length - 1, thirdPointer = newArray.length - 1;
        while (firstPointer >=0 && secondPointer >= 0) {
            if(array2[secondPointer] >= array1[firstPointer]) {
                newArray[thirdPointer] = array2[secondPointer];
                secondPointer--;
            } else {
                newArray[thirdPointer] = array1[firstPointer];
                firstPointer--;
            }
            thirdPointer--;
        }

        while(firstPointer >=0) {
            newArray[thirdPointer] = array1[firstPointer];
            firstPointer--;
            thirdPointer--;
        }

        while(secondPointer >= 0) {
            newArray[thirdPointer] = array2[secondPointer];
            secondPointer--;
            thirdPointer--;
        }
        int median;
        if(newArray.length % 2 == 0) {
            median = (newArray[(newArray.length/2) - 1] + newArray[newArray.length / 2]) / 2;
        } else {
            median = newArray[(newArray.length/2)];
        }
        return median;
    }

//    public static int[] findSum(int[] arr, int n) {
//        int[] result = new int[2];
//        Arrays.sort(arr);
//
//        int left = 0, right = arr.length - 1;
//
//        while(left < right) {
//            if(arr[left] + arr[right] == n) {
//                result[0] = arr[left];
//                result[1] = arr[right];
//                return result;
//            } else if(arr[left] + arr[right] > n) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        // write your code here
//        return result; // return the elements in the array whose sum is equal to the value passed as parameter
//    }

    private static int[] findSum(int[] array, int number) {
        HashMap<Integer, Boolean> sumMap = new HashMap<>();
        int[] result = new int[2];

        for (int item : array) {
            sumMap.put(number - item, true);
        }

        for (int value : array) {
            if (sumMap.get(value) != null) {
                result[0] = value;
                result[1] = number - value;
            }
        }

        return result;
    }
}
