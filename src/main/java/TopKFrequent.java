import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {
 int[] topKFrequent(int[] nums ,int k) {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

     for (int n : nums) {
         map.put(n,map.getOrDefault(n,0)+1);
     }
     int size = map.size();
     int[] keys = new int[size];
     int i =0;
     for (int key : map.keySet()) {
         keys[i++] = key;
     }
     select(keys,map,0,size-1,size-k);
     return Arrays.copyOfRange(keys,size-k,size);

}

    private void select(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int kSmallest
    ) {
        while (left != right) {
            int pivot = partition(keys, map, left, right, (left + right) / 2);

            if (kSmallest == pivot) return;

            if (kSmallest < pivot) right = pivot - 1; else left = pivot + 1;
        }
    }
    private int partition(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int pivot
    ) {
        int pivotValue = map.get(keys[pivot]);
        swap(keys, pivot, right);
        int index = left;

        for (int i = left; i <= right; i++) if (map.get(keys[i]) < pivotValue) {
            swap(keys, i, index);
            index++;
        }
        swap(keys, right, index);
        return index;
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

}
