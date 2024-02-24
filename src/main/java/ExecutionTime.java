import java.util.*;
// ibm
public class ExecutionTime {
    /*
    When multiple tasks are executed on a single-threaded CPU, the tasks are scheduled based on the principle of pre-emption.
    When a higher-priority task arrives in the execution queue, then the lower-priority task is pre-empted, i.e.
    its execution is paused until the higher-priority task is complete.
There are n functions to be executed on a single-threaded CPU, with each function having a unique
ID between 0 and n - 1. Given an integer n, representing the number of functions to be executed, and an
 execution log as an array of strings, logs, of size m, determine the exclusive times of each of the functions.
 Exclusive time is the sum of execution times for all calls to a function.
Any string representing an execution log is of the form (function_id): ("start" |"end"?: (timestamp},
indicating that the function with ID = function_ id,
either starts or ends at a time identified by the timestamp value.
     */



        public static List<Integer> getTotalExecutionTime(int n, List<String> logs) {
            List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
            Stack<Integer> stack = new Stack<>();
            int prevTimestamp = 0;

            for (String log : logs) {
                String[] logParts = log.split(":");
                int functionId = Integer.parseInt(logParts[0]);
                String action = logParts[1];
                int timestamp = Integer.parseInt(logParts[2]);

                if (action.equals("start")) {
                    if (!stack.isEmpty()) {
                        result.set(stack.peek(), result.get(stack.peek()) + timestamp - prevTimestamp);
                    }
                    stack.push(functionId);
                    prevTimestamp = timestamp;
                } else { // action == "end"
                    result.set(stack.peek(), result.get(stack.peek()) + timestamp - prevTimestamp + 1);
                    stack.pop();
                    prevTimestamp = timestamp + 1;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int n = 3;
            List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "2:start:6", "2:end:9", "0:end:12");
            List<Integer> result = getTotalExecutionTime(n, logs);
            System.out.println(result);
        }
    }


