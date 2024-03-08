package misc;

public class MinimizeString {

    public static int minimizeString(String seq) {
        StringBuilder sb = new StringBuilder(seq);
        int i = 0;

        while (i < sb.length() - 1) {
            if (sb.charAt(i) == 'A' && sb.charAt(i + 1) == 'B') {
                sb.delete(i, i + 2); // Remove "AB"
                i = Math.max(0, i - 1); // Move back one index if possible
            } else if (sb.charAt(i) == 'B' && sb.charAt(i + 1) == 'B') {
                sb.delete(i, i + 2); // Remove "BB"
                i = Math.max(0, i - 1); // Move back one index if possible
            } else {
                i++;
            }
        }

        return sb.toString().length();
    }

    public static void main(String[] args) {
        String seq = "BABBA";
        int minimizedSeq = minimizeString(seq);
        System.out.println("The length of the minimized string is: " + minimizedSeq);
    }
}
