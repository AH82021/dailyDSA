package misc;
/*
You are developing a simple version control system. Your system can support branches, and you can switch between branches or update the files in a branch using the following actions: - switch <branch name> - switches to the branch with the given name. - push <file name> - pushes a file to the current branch. Note that if the file was pushed to the current branch before, then the number of files should not be changed. Your task is to process all the logs and return the branch name that contains the largest number of files at the end. It is guaranteed that there is no tie. Notes: - It is guaranteed that the first command is "switch." - It is guaranteed that there is at least one "push" command.
are developing a simple version control system. Your system can support branches, and you can switch between branches or update the files in a branch using the following actions:
- switch <branch name> - switches to the branch with the given name.
- push <file name> - pushes a file to the current branch. Note that if the file was pushed to the current branch before, then the number of files should not be changed.

Your task is to process all the logs and return the branch name that contains the largest number of files at the end. It is guaranteed that there is no tie.

Notes:
- It is guaranteed that the first command is "switch."
- It is guaranteed that there is at least one "push" command.
 input = ["switch branch1", "push file1","push file2","push file1","switch branch2","switch issue2","push file1","push file2","push file3"]
  output = ["issue2"]

  To solve this problem, we will need to parse the logs to keep track of the current branch and the number of unique files in each branch.
  At the end, we will determine which branch has the most files. Here is a high-level algorithm:

Initialize a map to keep track of the file count for each branch.
Initialize a variable to keep track of the current branch.
Loop through each entry in the logs array.
If the log entry is a switch, change the current branch.
If the log entry is a push, increment the file count for the current branch if the file hasn't been pushed to this branch before.
After processing all logs, determine the branch with the most files.
Return the name of that branch.


 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VersionControlSystem {
    public static String solution(String[] logs){
        Map<String,Integer> fileCount = new HashMap<>();
        Map<String, HashSet<String>> branchFiles = new HashMap<>();
        String currentBranch = "";

        for (String log : logs) {
           if(log.startsWith("switch")){
               currentBranch = log.split("")[1];
               branchFiles.putIfAbsent(currentBranch,new HashSet<>());
           } else  if(log.startsWith("push")){
               String file = log.split("")[1];
               HashSet<String> files = branchFiles.get(currentBranch);
               if(!files.contains(file)){
                   files.add(file);
                   fileCount.put(currentBranch,files.size());
               }
           }
        }
        return fileCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static void main(String[] args) {
         String[] logs = {"switch branch1", "push file1","push file2","push file1","switch branch2","switch issue2","push file1","push file2","push file3"};
        System.out.println(findBranchWithMostFiles(logs));
    }

    public static String findBranchWithMostFiles(String[] logs) {
        String currentBranch = null;
        Map<String, Set<String>> branchFileCounts = new HashMap<>();

        for (String log : logs) {
            String[] parts = log.split(" ");
            String action = parts[0];
            String argument = parts[1];

            if ("switch".equals(action)) {
                currentBranch = argument;
                branchFileCounts.putIfAbsent(currentBranch, new HashSet<>());
            } else if ("push".equals(action) && currentBranch != null) {
                String filename = argument;
                branchFileCounts.get(currentBranch).add(filename);
            }
        }

        // Find the branch with the maximum number of unique files
        int maxCount = 0;
        String mostFilesBranch = null;
        for (Map.Entry<String, Set<String>> entry : branchFileCounts.entrySet()) {
            int count = entry.getValue().size();
            if (count > maxCount) {
                maxCount = count;
                mostFilesBranch = entry.getKey();
            }
        }

        return mostFilesBranch;
    }
}
