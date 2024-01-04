import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public static int[] topKFrequentElement(int[] nums,int k){


        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }


        // create a priority queue to store the elements by their frequency
        // the element with the lowest frequency will be at the top of the queue


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        // iterate through the map and add the elements to the queue
        // if the queue size exceeds k, remove the top element
        for (int num : map.keySet()) {
            pq.offer(num);
            if(pq.size() >k){
                pq.poll();
            }
        }

        int[] result = new int[k];
    // pop the elements from the queue and add them to the result array
        for (int i = k-1;i>=0;i--){
            result[i] =pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,5};
        System.out.println(Arrays.toString(topKFrequentElement(nums,2)));
    }
}
