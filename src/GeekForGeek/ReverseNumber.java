package GeekForGeek;

public class ReverseNumber {

    public static void main(String[] args) {
        int number = 1212439071 ;

        int reversedNumber = reverseNumber(number);
        System.out.print(reversedNumber);
    }

    private static int reverseNumber(int number) {

        int reversedNumber = 0;
        while(number > 0) {
            reversedNumber = (reversedNumber*10) + number % 10;
            number = number / 10;
        }

        return reversedNumber;
    }
}
