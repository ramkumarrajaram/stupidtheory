package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinWindowSubString {
    public static void main(String[] args) {
        MinWindowSubString minWindowSubString = new MinWindowSubString();

        String s = "ADOBECODEBANC", t = "ABC";
        minWindowSubString.minWindow(s, t);
    }

    private String minWindow(String s, String t) {

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            charSet.add(t.charAt(i));
        }

        int windowStart =0; int minWindowStartPos = 0; int minWindowEndPos = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            Character rightChar = s.charAt(windowEnd);

            if(hashMap.isEmpty() && !charSet.contains(rightChar)) {
                windowStart++;
                continue;
            }

            if(charSet.contains(rightChar)) {
                if(hashMap.isEmpty()) {
                    windowStart = windowEnd;
                    minWindowStartPos = windowStart;
                }
                hashMap.put(rightChar, windowEnd);
            }
        }

        return "";
    }
}
