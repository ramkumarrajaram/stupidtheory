package GeekForGeek;

public class ReverseArray {

    public static void main(String args[]) {

        int[] array = {1, 2, 3, 4, 5, 6};

        int[] reversedArray = reverseArray(array);
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.println(reversedArray[i]);
        }
    }

    private static int[] reverseArray(int[] array) {
        int i = 0, j = array.length - 1;

        while(i < j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
            i++;
            j--;
        }
        return array;
    }
}
    