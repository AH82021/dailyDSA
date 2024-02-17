package misc;

public class FindMaxSubArray {
    //Kadane's Algorithm
    public static int findMaxSubArray(int[] array){

        int currentSum =array[0];
        int maxSum = array[0];

        for (int i = 1; i < array.length; i++) {
            if(array[i] >currentSum +array[i]){
              currentSum = array[i]  ;
            } else currentSum = currentSum + array[i];
            if(currentSum >maxSum){
                maxSum = currentSum;
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {1,2,-3,4,5,6};
        System.out.println(findMaxSubArray(array));
    }
}
