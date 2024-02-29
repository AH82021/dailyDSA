package misc;
public class DNAComplement {
    public static String dnaComplement(String s) {
        // Create a StringBuilder to store the reverse complemented DNA string
        StringBuilder reverseComplement = new StringBuilder();

        // Iterate through the characters of the input string in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            // Append the complement of the current character to the result
            switch (currentChar) {
                case 'A':
                    reverseComplement.append('T');
                    break;
                case 'T':
                    reverseComplement.append('A');
                    break;
                case 'C':
                    reverseComplement.append('G');
                    break;
                case 'G':
                    reverseComplement.append('C');
                    break;
                // Handle invalid characters if necessary
                default:
                    // For now, let's assume all characters in the input string are valid
                    break;
            }
        }

        // Convert the StringBuilder to a String and return the result
        return reverseComplement.toString();
    }

    public static void main(String[] args) {
        // Test the function with sample input
        String inputString = "ACCGGGTTTT";

        String outputString = dnaComplement(inputString);
        System.out.println(outputString); // Output should be "AAAACCCGGT"
    }


}
