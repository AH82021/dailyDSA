package pmc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemAnaStrings {
    public static List<String> getWho(List<String> s){
        List<String> winners = new ArrayList<>();
        for (String code : s) {
            int vowelCount = countVowel(code);
            if (vowelCount!=0 || vowelCount % 2 != 0) {
                winners.add("Alex");
            } else {
                winners.add("Chris");
            }
        }

        return winners;
    }

    private static int countVowel(String code) {
        int count = 0;
        code = code.toLowerCase();
        for (char c : code.toCharArray()) {
            if(c=='a' || c =='e' || c=='i' || c=='o' || c=='u') {
                count ++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("ljis","lhr","gms");
        System.out.println(getWho(arr));
    }
}