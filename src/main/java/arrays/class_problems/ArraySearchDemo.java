package arrays.class_problems;

// class problem 1: linear search in array
public class ArraySearchDemo {

    // function to search element linearly
    public static int linearSearch(int[] arr, int target) {
        if(arr == null) return -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i; // found at index i
            }
        }
        return -1; // not found
    }

    // count how many times target appears
    public static int countOccurrences(int[] arr, int target) {
        if(arr == null) return 0;
        int count = 0;
        for(int num : arr) {
            if(num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] scores = {45, 88, 72, 90, 88, 60};
        int target = 88;

        System.out.println("Searching for " + target + " in array:");
        int idx = linearSearch(scores, target);
        int freq = countOccurrences(scores, target);

        System.out.println("First found at index: " + idx);
        System.out.println("Total occurrences: " + freq);
    }
}
