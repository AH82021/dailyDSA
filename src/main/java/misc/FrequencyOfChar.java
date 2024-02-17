package misc;

import java.util.HashMap;
import java.util.Map;
//Find the frequency of each char in String.

public class FrequencyOfChar {
    public static void getCharacterFrequency(String str){
        str=str.toLowerCase();
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (char c : chars) {
            if(Character.isLetter(c)){
               map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        System.out.println(map);
    }

}


