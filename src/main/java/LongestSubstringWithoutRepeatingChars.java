import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s){
        List<Character> substringLength = new ArrayList<>();
        int longestLength = 0;

        for(int right = 0; right < s.length(); right++){
            if(substringLength.contains(s.charAt(right))){
                int index = substringLength.indexOf(s.charAt(right));
                substringLength.remove(index);
                if(index>0){ substringLength.subList(0,index).clear();}

            }
            substringLength.add(s.charAt(right));
            longestLength = Math.max(longestLength, substringLength.size());
        }

 return longestLength;
    }
    public int lengthOfLongestSubstring2(String s) {
        // initialize a hash map to store the indices of the characters
        HashMap<Character, Integer> map = new HashMap<>();
        // initialize the start and end of the window, and the result
        int start = 0, end = 0, result = 0;
        // loop through the string
        while (end < s.length()) {
            // get the current character
            char c = s.charAt(end);
            // if the character is already in the map, update the start of the window
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            // update the map with the current index
            map.put(c, end);
            // update the result with the current window length
            result = Math.max(result, end - start + 1);
            // increment the end of the window
            end++;
        }
        // return the final result
        return result;
    }

}
