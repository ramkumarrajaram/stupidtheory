package leetcode;

public class RainWaterTrap_another_method {

    public static void main(String[] args) {
        int[] buildings = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int length = buildings.length;

        int left = 0, right = length - 1;
        int trapped_water = 0, temp_value;
        while (left < right) {
            if (buildings[left] > buildings[right]) {
                temp_value = buildings[right];
                right--;
                while (right > left && temp_value >= buildings[right]) {
                    trapped_water += temp_value - buildings[right];
                    right--;
                }
            } else {
                temp_value = buildings[left];
                left++;
                while (right > left && temp_value >= buildings[left]) {
                    trapped_water += temp_value - buildings[left];
                    left++  ;
                }
            }
        }

        System.out.println("water in between buildings is " + trapped_water);

    }
}


//public class RainWaterTrap_another_method {
//
//    public static void main(String[] args) {
////        int[] buildings = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
////        int[] buildings = {4,2,0,3,2,5}
//
////        int[] buildings = {3, 0, 2, 0, 4};
//        int[] buildings = {4, 0, 2};
//        int length = buildings.length;
//
//        int i = 0, j = 1;
//        int trapped_water = 0;
//        while (j < length) {
//            if (buildings[i] > buildings[j]) {
//                trapped_water += buildings[i] - buildings[j];
//            } else {
//                i = j;
//            }
//            j++;
//        }
//
//        j--;
//        if (j - i > 1) {
//            while (j - i > 1) {
//                trapped_water = trapped_water - (buildings[i] - buildings[j]);
//                j--;
//            }
//        }
//
//        System.out.println("water in between buildings is " + trapped_water);
//
//    }
//}
