import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (Integer num : nums) {
            if(numSet.contains(num)) return true;
            numSet.add(num);
        }
        return false;

    }
}
