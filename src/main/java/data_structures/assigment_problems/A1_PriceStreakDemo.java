package data_structures.assigment_problems;

import java.util.Arrays;

// Demo runner for the canteen price streak.
public class A1_PriceStreakDemo {
    public static void main(String[] args) {
        PriceStreakCalculator calc = new PriceStreakCalculator();

        int[] week = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(calc.priceStreak(week)));

        int[] rising = {10, 20, 30};
        System.out.println(Arrays.toString(calc.priceStreak(rising)));

        int[] falling = {50, 40, 30};
        System.out.println(Arrays.toString(calc.priceStreak(falling)));

        System.out.println(Arrays.toString(calc.priceStreak(new int[0])));
    }
}
