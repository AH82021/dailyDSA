package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of characters where each character represents a fruit tree,
you are given two baskets and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but once you have started you can’t skip a tree.
 You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class FruitsIntoBaskets {
public static int findLength(char[] arr){
    int windowStart =0 , maxLength = 0;

    Map<Character,Integer> fruitFrequencyMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd <arr.length ; windowEnd++) {
        fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd],0)+1);

        while (fruitFrequencyMap.size()>2){
            fruitFrequencyMap.put(arr[windowStart],fruitFrequencyMap.get(arr[windowStart])-1);
            if(fruitFrequencyMap.get(arr[windowStart])==0){
                fruitFrequencyMap.remove(arr[windowStart]);
            }
            windowStart++; // shrink the widow
        }
        maxLength = Math.max(maxLength,windowEnd-windowStart +1);
    }
 return  maxLength;
}


}
