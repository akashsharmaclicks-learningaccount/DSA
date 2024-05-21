package Array;

public class ArrayUtil {

    // Method to print elements of an array
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method to remove even numbers from an array and return the resulting array
    public static int[] removeEven(int[] arr) {
        int oddElementsCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddElementsCount++;
            }
        }

        int[] resultArr = new int[oddElementsCount];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                resultArr[idx] = arr[i];
                idx++;
            }
        }

        return resultArr;
    }
}

class Runner_2 {
    public static void main(String[] args) {
        ArrayUtil obj = new ArrayUtil();
        int[] dummyArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Print the original array
        obj.printArray(dummyArray);

        // Remove even numbers and print the resulting array
        int[] resultArray = ArrayUtil.removeEven(dummyArray);
        obj.printArray(resultArray);
    }
}
