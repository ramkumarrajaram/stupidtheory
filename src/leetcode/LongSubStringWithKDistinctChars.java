package leetcode;

import java.util.HashMap;

public class LongSubStringWithKDistinctChars {

    public static void main(String[] args) {
        String input = "cbbebi";

        System.out.println("The longest substring chars data is : " + getLongestSubString(input));
    }

    private static int getLongestSubString(String str) {

        int k = 3;

        int windowStart = 0;
        int longestChar = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if (hashMap.get(str.charAt(windowEnd)) != null) {
                hashMap.put(str.charAt(windowEnd), hashMap.get(str.charAt(windowEnd)) + 1);
            } else {
                hashMap.put(str.charAt(windowEnd), 1);
            }

            while (hashMap.keySet().size() > k) {
                if (hashMap.get(str.charAt(windowStart)) == 1) {
                    hashMap.remove(str.charAt(windowStart));
                } else {
                    hashMap.put(str.charAt(windowStart), hashMap.get(str.charAt(windowEnd)) - 1);
                }
                windowStart++;
                longestChar = Math.max(longestChar, windowEnd - windowStart + 1);
            }
        }

        return longestChar;
    }
}
