package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Permutation in a String (hard) #
Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string.
For example, “abc” has the following six permutations:
abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters it will have
n! permutations.
Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
Solution #
This problem follows the Sliding Window pattern and we can use a similar sliding
window strategy as discussed in Longest Substring with K Distinct Characters.
We can use a HashMap to remember the frequencies of all characters in the given pattern.
Our goal will be to match all the characters from this HashMap with a sliding window in the given string.
Here are the steps of our algorithm:

Create a HashMap to calculate the frequencies of all characters in the pattern.
Iterate through the string, adding one character at a time in the sliding window.
If the character being added matches a character in the HashMap, decrement its frequency in the map. If the character frequency becomes zero, we got a complete match.
If at any time, the number of characters matched is equal to the number of distinct characters in the pattern (i.e., total characters in the HashMap), we have gotten our required permutation.
If the window size is greater than the length of the pattern, shrink the window to make it equal to the size of the pattern. At the same time, if the character going out was part of the pattern, put it back in the frequency HashMap.
 */
public class StringPermutation {
    public static boolean findPermutation(String str,String pattern) {
        int windowStart =0;
        int matched = 0;
        Map<Character,Integer> charFrequenciesMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            charFrequenciesMap.remove(c,charFrequenciesMap.getOrDefault(c,0)+1);

        }
        for (int windowEnd =0;windowEnd<str.length();windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(charFrequenciesMap.containsKey(rightChar)){
                charFrequenciesMap.put(rightChar,charFrequenciesMap.get(rightChar)-1);
                if(charFrequenciesMap.get(rightChar)==0){
                    matched ++;
                }
                if ((matched == charFrequenciesMap.size())){
                    return  true;
                }
                if(windowEnd >= pattern.length() -1){
                    char leftChar = str.charAt(windowStart++);
                    if(charFrequenciesMap.containsKey(leftChar)){
                        matched --;
                        charFrequenciesMap.put(leftChar,charFrequenciesMap.get(leftChar)+1);
                    }
                }
            }
        }
        return false;
    }


}
