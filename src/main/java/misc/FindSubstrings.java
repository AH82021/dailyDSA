package misc;

import java.util.*;


public class FindSubstrings {


    public static void main(String[] args) {
        String testString = "abac";
        System.out.println(findSubstrings("bcada"));
    }



    // A function to find the number of substrings in a string that have no repeating characters
    public static int findSubstrings(String s) {
        // Initialize a variable to store the result
        int count = 0;
        // Loop through the string from left to right
        for (int i = 0; i < s.length(); i++) {
            // Initialize a set to store the characters seen so far
            Set<Character> seen = new HashSet<>();
            // Loop through the string from right to left, starting from i
            for (int j = i; j < s.length(); j++) {
                // Get the current character
                char c = s.charAt(j);
                // If the character is already in the set, break the loop
                if (seen.contains(c)) {
                    break;
                }
                // Otherwise, add the character to the set and increment the count
                seen.add(c);
                count++;
            }
        }
        // Return the result
        return count;
    }



}






