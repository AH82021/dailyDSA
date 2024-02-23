package misc;


/*
Your challenge is to sort a string, but rather than by the normal alphabetical order (abc..xyz), you will be sorting strings by a specified alphabet.

You must write a program or function that takes two inputs: An alphabet A and an string S. Both will only contain lowercase English letters, and both will contain at least one character.

You must move letters in S so that the letter that appears first in A appears first, then whichever letter appears second in A, etc. There may be some letters in S that do not appear in A, these should be left at the end and not moved around relative to each other.

Test cases:

A       S               Result
axd     haxuizzxaxduxha aaaxxxxdhuizzuh
a       xyz             xyz
abc     dcba            abcd
il      nmiuplliu       iillnmupu
asdf    qwerty          qwerty
 */

import java.util.Arrays;
import java.util.Comparator;

public class CustomOrderStringSort {
    public static void main(String[] args) {
//        String str = "yourStringHere";
//        String order = "customOrder";
//        String sortedStr = sortStringBasedOnOrder(str, order);
//        System.out.println(sortedStr);

        String orderStr = "abc";
        String s =  "dcba";
        System.out.println(sortStringBasedOnOrder(s, orderStr));

    }

    public static String sortStringBasedOnOrder(String str, String order) {
        Character[] characters = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            characters[i] = str.charAt(i);
        }

        Arrays.sort(characters, (c1, c2) -> {
            int index1 = order.indexOf(c1);
            int index2 = order.indexOf(c2);
            System.out.println(index1+" "+index2);
            // If both characters are in the order string, compare their positions
            if (index1 != -1 && index2 != -1) {
                return index1 - index2;
            }
            // If only the first character is in the order string, it comes first
            else if (index1 != -1) {
                return -1;
            }
            // If only the second character is in the order string, it comes first
            else if (index2 != -1) {
                return 1;
            }
            // If neither character is in the order string, maintain their current order
            else {
                return c1.compareTo(c2);
            }
        });

        StringBuilder sb = new StringBuilder(characters.length);
        for (Character c : characters) {
            sb.append(c);
        }
        return sb.toString();
    }
}
