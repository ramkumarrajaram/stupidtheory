package leetcode;

class MinimumCoinReversal
{
    static int minReplacement(int[] array, int len)
    {
        int ans = 0;
        for (int i = 0; i < len; i++) {

            if (i % 2 == 0 && array[i] == 1)
                ans++;

            if (i % 2 == 1 && array[i] == 0)
                ans++;
        }
        return Math.min(ans, len - ans);
    }

    // Driver code
    public static void main(String args[])
    {
        int[] array = {1 ,1, 0, 0};
        int len = array.length;
        System.out.print(minReplacement(array, len));
    }
} 