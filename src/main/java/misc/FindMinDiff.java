package misc;

import java.util.*;

public class FindMinDiff {
    /*
    Time Complexity:

O(nlogn)
Space Complexity:
O(n)
     */

    public static  void  findClosestNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        int minDiff = Integer.MAX_VALUE;

        ArrayList<String> pairs = new ArrayList<>();
        for (int i = 0; i < numbers.size()-1; i++) {
            int diff = Math.abs(numbers.get(i)-numbers.get(i+1));
            if (diff < minDiff){
                minDiff = diff;
                // start a new list if new minimum difference is found
                pairs.clear();
                pairs.add(numbers.get(i)+" "+numbers.get(i+1));
            } else if (diff == minDiff) {
                pairs.add(numbers.get(i)+" "+numbers.get(i+1));

            }
        }
        for (String pair : pairs) {
            System.out.println(pair);
        }

    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 2, 4, 10);
        findClosestNumbers(numbers);
    }
}
