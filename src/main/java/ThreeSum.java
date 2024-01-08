import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            //Only consider non-duplicate elements for i
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ArrayList<Integer> miniRes = new ArrayList<>();
                        miniRes.add(nums[i]);
                        miniRes.add(nums[left]);
                        miniRes.add(nums[right]);
                        result.add(miniRes);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
