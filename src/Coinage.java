import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Coinage  {

    private static List<Integer> resultArray = new ArrayList();
    private static int remainder;
    private static int largest;

    public static void main(String args[]) {
        List<Integer> denoms = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200);

        List<Integer> calculate = calculate(560, denoms);
        System.out.print(calculate + " ------------ ");
    }
    public static List<Integer> calculate(final int amt, List<Integer> denoms) {
        List<Integer> value = denoms.stream().filter(element -> element<=amt).collect(toList());
        largest = value.get(value.size()-1);
        resultArray.add(largest);
        remainder = amt - largest;

        if (remainder == 0 || remainder == amt) {
            return resultArray;
        } else return calculate(remainder, denoms);
    }
}
