package leetcode;

class MinSizeSubArraySum {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        System.out.println(findMinSubArray(15, array));
    }

    public static int findMinSubArray(int s, int[] nums) {
        // TODO: Write your code here
        for (int value : nums) {
            if (value >= s) {
                return 1;
            }
        }

        int minimum_count = Integer.MAX_VALUE;
        int current_count = 0, windowSum = 0;
        int i = 0;
        int j = 1;


        while (i < nums.length && j < nums.length) {
            if (windowSum == 0) {
                windowSum = nums[i] + nums[j];
                current_count = 2;
                j++;
                if(j == nums.length && i <= nums.length - 1) {
                    j = nums.length - 1;
                } 
            } else if (windowSum < s) {
                windowSum += nums[j];
                current_count++;
                j++;
                if(j == nums.length && i <= nums.length - 1) {
                    j = nums.length - 1;
                }
            } else {
                minimum_count = Math.min(minimum_count, current_count);
                windowSum = 0;
                i++;
                j = i + 1;
            }
        }
        return minimum_count < Integer.MAX_VALUE ? minimum_count : 0;
    }
}
