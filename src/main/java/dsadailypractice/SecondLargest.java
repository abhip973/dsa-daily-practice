package dsadailypractice;

public class SecondLargest {

    /*
    Problem Statement: Find the Second Largest Element in an Array
    Corner cases to cover:
    1. Array can contain duplicates.
    2. Array can contain negatives.
    3. Array can be empty array.
     */

    public static void main(String[] args) {
        int[] array = {2, 4, 7, 6, 9, 1, 8, 9};
        System.out.println(secondLargestNumber(array));
    }

    public static int secondLargestNumber(int[] arr) {
        int largestNumber = arr[0];
        int secondLargestNumber = arr[0];
        if (arr.length < 2) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestNumber) {
                secondLargestNumber = largestNumber;
                largestNumber = arr[i];
            } else if (arr[i] > secondLargestNumber && arr[i] != largestNumber) {
                secondLargestNumber = arr[i];
            }
        }

        return secondLargestNumber;
    }
}
