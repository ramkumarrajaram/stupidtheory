package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Insomnia {

    public static void main(String args[]) {
        int n = 1122332133;

        Set<Integer> numbers = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        String nannySheep = findNannySheep(n, numbers);

        System.out.print(nannySheep);
    }

    private static String findNannySheep(int n, Set<Integer> numbers) {
        try {
            if (n == 0) {
                return "INSOMNIA";
            }

            int lastNumber;
            for (int i = 1; ; i++) {
                lastNumber = i*n;
                int digitsToAdd = lastNumber;
                while (digitsToAdd > 0) {
                    numbers.remove( digitsToAdd % 10 );
                    digitsToAdd = digitsToAdd / 10;
                }

                if (numbers.isEmpty()) {
                    return String.valueOf(lastNumber);
                }
            }
        } catch (StackOverflowError error) {
            return "INSOMNIA";
        }
    }
}
