package cp1;
/*
Given a string message and an integer n
replace every
th consonant with the next consonant from the alphabet while keeping the case consistent (e.g. *b becomes *c*
'x' becomes "y',
etc.).
Notes:
RULES
• The list of consonants in alphabetical order Is;oed，
'z' must be replaced with 'b' (and z with = 'B').
.
 */

public class ConsonantReplacer {
    public static String replaceNthConsonant(String message, int n) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int count = 0;

        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (consonants.indexOf(Character.toLowerCase(c)) != -1) {
                count++;
                if (count % n == 0) {
                    int index = consonants.indexOf(Character.toLowerCase(c));
                    char nextConsonant = consonants.charAt((index + 1) % consonants.length());
                    // Preserve the case
                    nextConsonant = Character.isUpperCase(c) ? Character.toUpperCase(nextConsonant) : nextConsonant;
                    sb.append(nextConsonant);
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String message = "GeekforGeeks";
        int n = 3;
        System.out.println(replaceNthConsonant(message, n));
    }

//    static boolean isVowel(char ch)
//    {
//        if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o'
//                && ch != 'u') {
//            return false;
//        }
//        return true;
//    }
//
//    // Function that replaces consonant with
//    // next immediate consonant alphabetically
//    static String replaceConsonants(String str)
//    {
//        char[] s = str.toCharArray();
//        // Start traversing the string
//        for (int i = 0; i < s.length; i++) {
//            if (!isVowel(s[i])) {
//
//                // if character is z,
//                // than replace it with character b
//                if (s[i] == 'z') {
//                    s[i] = 'b';
//                }
//
//                // if the alphabet is not z
//                else {
//
//                    // replace the element with
//                    // next immediate alphabet
//                    s[i] = (char)(s[i] + 1);
//
//                    // if next immediate alphabet is vowel,
//                    // than take next 2nd immediate alphabet
//                    // (since no two vowels occurs
//                    // consecutively in alphabets) hence no
//                    // further checking is required
//                    if (isVowel(s[i])) {
//                        s[i] = (char)(s[i] + 1);
//                    }
//                }
//            }
//        }
//        return String.valueOf(s);
//    }
}
