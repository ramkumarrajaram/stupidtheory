package GeekForGeek;

public class SwapNumbersWithBits {


    public static void main(String[] args) {
       int a = 10;
       int b = 20;

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.print(a +" " +b );
    }
}
