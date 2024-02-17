package misc;
/*
One of your new coworkers has submitted code with variable names in snake case, where multiword names are separated by underscores (such as my_counter). Your company's convention is to use only lower camel case, where multiword variable names are concatenated, capitalizing the first letter of every word except the first (e.g. myCounter).

Your team is tasked with taking the source code src from your coworker, and returning code with the all the names in snake case converted into lower camel case. More specifically:

Variable names may start with one or more underscores, and these should be preserved. For example _the_variable should become _theVariable
Variable names may end with trailing underscores, and these should be preserved. For example, the_variable__ should become theVariable__.
To keep the problem simple, you are not restricted to variable names, but instead should replace all instances of snake case.
Example

For src = "This is the doc_string for __secret_fun", the output should be
snakeToCamel(src) = "This is the docString for __secretFun".
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class snakeToCamel{



        public static String convert(String src) {
            boolean capitalizeNext = false;
            StringBuilder sb = new StringBuilder();

            // Preserve leading underscores
            while (src.startsWith("_")) {
                sb.append('_');
                src = src.substring(1);
            }

            for (char c : src.toCharArray()) {
                if (c == '_') {
                    capitalizeNext = true;
                } else if (capitalizeNext) {
                    sb.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    sb.append(c);
                }
            }

            // Preserve trailing underscores
            while (src.endsWith("_")) {
                sb.append('_');
                src = src.substring(0, src.length() - 1);
            }

            return sb.toString();
        }






    public static void main(String[] args) {

        String src = "another_variable__";
        String src2 = "_one_variable__";
        String src3 = "__matthew jeshua__martin";

        System.out.println("---------------------------");
        System.out.println(convert(src3));
    }






}
