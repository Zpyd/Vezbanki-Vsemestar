public class WEAK_knapSack {
    // Method to solve the knapsack problem using brute force
    public static int knapsackBrute(int[] weights, int[] values, int W, int n) {
        // Base case: no items left or capacity is 0
        if (n == 0 || W == 0) {
            return 0;
        }

        // If weight of the nth item is more than the knapsack capacity W, it cannot be included
        if (weights[n - 1] > W) {
            return knapsackBrute(weights, values, W, n - 1);
        } else {
            // Otherwise, we consider the two cases:
            // 1. Including the nth item
            // 2. Excluding the nth item

            int includeItem = values[n - 1] + knapsackBrute(weights, values, W - weights[n - 1], n - 1);
            int excludeItem = knapsackBrute(weights, values, W, n - 1);

            // Return the maximum of including or excluding the item
            return Math.max(includeItem, excludeItem);
        }
    }

    public static void main(String[] args) {
        // Define weights and values of items
        int[] weights = {2, 5,10,5};
        int[] values = {20,30,50,10};
        int W = 17; // Capacity of the knapsack
        int n = weights.length;

        int maxProfit = knapsackBrute(weights, values, W, n);
        System.out.println("Maximum value in Knapsack = " + maxProfit);
    }
}
