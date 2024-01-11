import java.util.ArrayList;
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
}
