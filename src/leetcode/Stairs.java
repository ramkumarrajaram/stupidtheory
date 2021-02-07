package leetcode;

import java.util.HashMap;
import java.util.Map;

class Stairs {

    public static void main(String[] args) {
        Stairs stairs = new Stairs();

        int climbStairs = stairs.climbStairs(45);
        System.out.println(climbStairs);
    }
    public int climbStairs(int n) {
        
        Map<Integer, Integer> memory = new HashMap();
        return calculate(n, memory);
        
    }
    
    public int calculate(int n, Map<Integer, Integer> memory) {
        if(memory.get(n) != null) {
            return memory.get(n);
        }
        if(n == 1 || n == 2) {
            return n;
        }
        
        memory.put(n, (calculate(n-1, memory) + calculate(n-2, memory)));
        return memory.get(n);
    }
}