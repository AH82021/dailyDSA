package pmc;

import java.util.*;

public class Lottery{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = solve(n);
        System.out.println(answer);
    }

    public static int solve(int n){
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxSum = -1, answer = 0;
        for(int i=1;i<=n;i++){
            int sum = getSum(i);
            freqMap.put(sum, freqMap.getOrDefault(sum,0)+1);
            maxSum = Math.max(maxSum, freqMap.get(sum));
        }
        for(int value : freqMap.values())       if(value==maxSum)   answer++;
        return answer;
    }

    public static int getSum(int n){
        int sum = 0;
        while(n>0){
            sum += (n%10);      n = n/10;
        }
        return sum;
    }
}
