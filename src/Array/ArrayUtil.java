package Array;

public class ArrayUtil {

    // Method to print elements of an array
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method to remove even numbers from an array
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

    // Method to remove odd numbers from an array
    public static int[] removeOdd(int[] arr) {
        int evenElementsCount = 0;
        for(int i=0; i<arr.length;i++) {
            if (arr[i] % 2 == 0) {
                evenElementsCount++;
            }
        }
        int[] resultArr = new int[evenElementsCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                resultArr[idx] = arr[i];
                idx++;
            }

        }
        return resultArr;
    }

    // Method to reverse the array elements.
    public static void reverseArray(int[] arr, int start, int end) {
        while (start<end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Method to find min element in an array
    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

}

class Runner_2 {
    public static void main(String[] args) {
        ArrayUtil obj = new ArrayUtil();
        int[] dummyArray = {2,11,5,10,7,8};

        // Print the original array
        System.out.println("Dummy Array:");
        obj.printArray(dummyArray);

        // Remove even numbers and print the resulting array
        System.out.println("Dummy Array after removing even elements:");
        int[] arrayResultWithoutEven = ArrayUtil.removeEven(dummyArray);
        obj.printArray(arrayResultWithoutEven);

        // Remove odd numbers and print the resulting array
        System.out.println("Dummy Array after removing odd elements:");
        int[] arrayResultWithoutOdd = ArrayUtil.removeOdd(dummyArray);
        obj.printArray(arrayResultWithoutOdd);

        // Reverse the array
        System.out.println("Reversed Array : ");
        ArrayUtil.reverseArray(dummyArray, 0, dummyArray.length-1);
        obj.printArray(dummyArray);

        // Minimum element in array
        System.out.println("Minimum element : ");
        System.out.println(ArrayUtil.findMinimum(dummyArray));
    }
}
