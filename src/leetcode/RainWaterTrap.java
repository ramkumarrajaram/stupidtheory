package leetcode;

public class RainWaterTrap {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        RainWaterTrap rainWaterTrap = new RainWaterTrap();

        System.out.println("Trapped water is "  + rainWaterTrap.trap(height));
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;

        int leftMaximum = 0, rightMaximum = 0;

        int trappedWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMaximum) {
                    leftMaximum = height[left];
                } else {
                    trappedWater += leftMaximum - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMaximum) {
                    rightMaximum = height[right];
                } else {
                    trappedWater += rightMaximum - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }
}
