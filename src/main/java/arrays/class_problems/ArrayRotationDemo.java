package arrays.class_problems;

import java.util.Arrays;

// class problem 2: rotating array by 1 position
public class ArrayRotationDemo {

    // left shift by 1 position
    public static void rotateLeftByOne(int[] arr) {
        if(arr == null || arr.length <= 1) return;
        int temp = arr[0];
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    // right shift by 1 position
    public static void rotateRightByOne(int[] arr) {
        if(arr == null || arr.length <= 1) return;
        int last = arr[arr.length - 1];
        for(int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40, 50};
        System.out.println("Original array: " + Arrays.toString(data));

        rotateLeftByOne(data);
        System.out.println("After 1 left rotation: " + Arrays.toString(data));

        rotateRightByOne(data);
        System.out.println("After 1 right rotation (restored): " + Arrays.toString(data));
    }
}
