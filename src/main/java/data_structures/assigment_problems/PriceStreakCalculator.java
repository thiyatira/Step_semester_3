package data_structures.assigment_problems;

import java.util.ArrayDeque;
import java.util.Deque;

// Computes the canteen price streak for every day using a stack of earlier day indices.
public class PriceStreakCalculator {

    public int[] priceStreak(int[] price) {
        if (price == null) {
            throw new IllegalArgumentException("price array must not be null");
        }
        int[] streak = new int[price.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            streak[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return streak;
    }
}
