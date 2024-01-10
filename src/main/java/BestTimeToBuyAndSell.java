public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length){
            if(prices[left] <prices[right]){
                maxProfit = Math.max(maxProfit, prices[right]-prices[left]);
            } else {
                left = right ;
            }
            right++;
        }
        return maxProfit;
    }


    public int maxProfit2(int[] prices) {
        int maxProfit=0;
        int minSoFar= prices[0];

        for (int price : prices) {
            minSoFar = Math.min(minSoFar, price);
            int profit = price - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;

    }
    public int maxProfit3(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprice = 0;

        for (int i : prices) {
            minprice = Math.min(minprice, i);
            maxprice = Math.max(maxprice, i - minprice);
        }

        return maxprice;
    }
}
