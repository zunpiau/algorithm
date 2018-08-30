package leetcode;

public class _122_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{9, 10, 7, 6, 5, 6};
        _122_BestTimeToBuyAndSellStock stock = new _122_BestTimeToBuyAndSellStock();
        System.out.println(stock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0, diff;
        for (int start = 0; start < prices.length - 1; start++) {
            if ((diff = prices[start + 1] - prices[start]) >= 0) {
                profit += diff;
            }
        }
        return profit;
    }

}
