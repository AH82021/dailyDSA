import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","anagram"));
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> count = new HashMap<>();

        for(char x: s.toCharArray()){
            count.put(x,count.getOrDefault(x,0)+1);
        }

        for(char x : t.toCharArray()){
            count.put(x,count.getOrDefault(x,0)-1);
        }

        for(int v :count.values()){
            if(v!=0){
                return false;
            }
        }

        return true;
    }
}
