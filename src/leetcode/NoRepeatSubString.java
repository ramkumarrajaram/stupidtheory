package leetcode;

import java.util.HashMap;

public class NoRepeatSubString {

    public static void main(String[] args) {
        String testString = "sindhuja";

        NoRepeatSubString subString = new NoRepeatSubString();

        int numberOfChars = subString.getNoRepeatSubString(testString);
        System.out.println(numberOfChars);
    }

    private int getNoRepeatSubString(String s) {
        int windowStart = 0;
        int maxChar = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            if (hashMap.containsKey(s.charAt(windowEnd))) {
                windowStart = Math.max(windowStart, hashMap.get(s.charAt(windowEnd)) + 1);
            }

            hashMap.put(s.charAt(windowEnd), windowEnd);
            maxChar = Math.max(maxChar, (windowEnd - windowStart + 1));
        }
        return maxChar;
    }
}
