package GeekForGeek;

import java.util.HashMap;

public class MergeArray {

    public static void main(String[] args) {
        int[] arr_one = {1, 3, 5, 7};
        int[] arr_two = {4, 2, 8, 6};

        MergeArray mergeArray = new MergeArray();
        Integer[] merge = mergeArray.merge(arr_one, arr_two);

        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i] + " ");
        }
    }

    private Integer[] merge(int[] arr_one, int[] arr_two) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int value : arr_one) {
            map.put(value, 0);
        }
        for (int value : arr_two) {
            map.put(value, 0);
        }

        return map.keySet().toArray(new Integer[arr_one.length+arr_two.length]);
    }
}
