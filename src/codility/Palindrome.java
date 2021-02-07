package codility;

public class Palindrome {

    public static void main(String[] x) {
        Palindrome palindrome = new Palindrome();

        String pal = "malayyalam";
        System.out.println(palindrome.isPalindrome(pal));
    }

    private boolean isPalindrome(String pal) {

        int length = pal.length();

        int x = 0, y = length - 1;

        while(x <= y) {
            if(pal.charAt(x) == pal.charAt(y)) {
                x++; y--;
            } else {
                return false;
            }
        }

        return true;
    }
}
