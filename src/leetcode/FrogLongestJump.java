package leetcode;

public class FrogLongestJump {
//    public int findMaxDistance(int[] blocks) {
//        Integer maxSum = null;
//        int start;
//        int maxDistance = 0;
//        int i;
//        if (blocks.length < 2) {
//            return blocks.length;
//        }
//        i = 0;
//        while (i < blocks.length - 1) {
//            while ((i - 1 >= 0) && (i < blocks.length) && (blocks[i - 1] == blocks[i]))
//                i--;
//            start = i;
//            int downSum = blocks[i];
//            while ((i + 1 < blocks.length) && (blocks[i + 1] <= blocks[i])) {
//                downSum += blocks[++i];
//            }
//            int upSum = 0;
//            while ((i + 1 < blocks.length) && (blocks[i + 1] >= blocks[i])) {
//                upSum += blocks[++i];
//            }
//            int sum = upSum + downSum;
//            if ((maxSum == null) || (sum > maxSum)) {
//                maxSum = sum;
//                maxDistance = i - start + 1;
//            }
//        }
//        return maxDistance;
//    }

    public int findMaxDistance(int[] blocks) {
        if (blocks.length <= 2) {
            return blocks.length;
        }
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0,start = 0,
                end = 0, s = 0;


        for (int i = 0; i < blocks.length; i++)
        {
            max_ending_here += blocks[i];

            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0)
            {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        return (end - start );
    }

    public static void main(String[] args) {
        int[] t = {2, 6, 8, 5};
        System.out.println(new FrogLongestJump().findMaxDistance(t));
        int[] t4 = {0, 6, 8, 1, 10, 11, 4};
        System.out.println(new FrogLongestJump().findMaxDistance(t4));
        int[] t2 = {1,5,5,2,6};
        System.out.println(new FrogLongestJump().findMaxDistance(t2));
        int[] t3 = {1,1};
        System.out.println(new FrogLongestJump().findMaxDistance(t3));
    }
}