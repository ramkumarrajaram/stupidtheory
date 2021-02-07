package codility;
//class Solution {
//    public static int solution(int N) {
//        // write your code in Java SE 8
//        String binary = Integer.toBinaryString(N);
//        int count = 0;
//        int result = 0;
//        boolean found_one = false;
//
//        int i = N;
//
//        while (i!= 0) {
//            if ((i & 1) == 1) {
//                System.out.println(i&1);
//                if(!found_one) {
//                    found_one = true;
//                } else {
//                    result = Math.max(result, count);
//                }
//                count = 0;
//            } else {
//                count +=1;
//            }
//
//            i >>=1;
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int solution = solution(9);
//        System.out.println("Solution is " + solution);
//    }
//}
//



import java.util.*;

public class Solution {
//    public static int solution(int[] ary) {
//        // write your code in Java SE 8
////        Arrays.sort(ary, (Integer i1, Integer i2) -> Math.abs(i2) - Math.abs(i1));
//
//
//        List<Integer> intList = new ArrayList<Integer>();
//        for (int index = 0; index < ary.length; index++) {
//            intList.add(ary[index]);
//        }
//
//        intList.sort((Integer i1, Integer i2) -> Math.abs(i2) - Math.abs(i1));
//
//        if(intList.get(intList.size()-1) < 0) {
//            return 1;
//        }
//
//        for(int i=0; i<intList.size(); i++) {
//            if(i == ((intList.size())-1)) {
//                return intList.get(i)+ 1;
//            }
//
//            if(intList.get(i) == intList.get(i+1)) {
//                continue;
//            }
//
//            if((intList.get(i+1) != intList.get(i)+1) || (intList.get(i+1) !=intList.get(i) )) {
//                return intList.get(i)+1;
//            }
//        }
//        return 1;
//    }
//
//        public static void main(String[] args) {
//        int[] ary = {1, 3, 6, 4, 1, 2};
//            int solution = solution(ary);
//            System.out.println(solution);
//        }

    static int smallest(int[] array) {
        LinkedList list = new LinkedList();
        Map<String, Integer> map = new HashMap<>();

        int index = 0;
        while(array[index] != -1) {
            list.add(array[index]);
            index = array[index];
        }

           return list.size();
    }

    // Driver Code
    public static void main(String[] args) {

        String s = "codility";
       // System.out.println(smallest(s.toCharArray()));
    }

}

