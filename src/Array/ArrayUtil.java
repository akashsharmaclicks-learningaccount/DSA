package Array;

import java.util.Arrays;

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

    // Method to find max element in an array
    public static int findMaximum(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Method to find second max element in an array
    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // Method to move the zeroes to the last
    public static void moveZeroesToLast(int[] arr, int n)
    {
        int j = 0;
        for(int i = 0; i<arr.length; i++ )
        {
            if(arr[i] != 0 && arr[j] == 0)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0)
            {
                j++;
            }
        }
    }

    // Method to resize an Array
    public static int[] resizeArray(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        return  arr;
    }

    // Method to find a missing number within a range of an Array
    public static int findMissingNum(int[] arr)
    {
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        for(int num : arr)
        {
            sum = sum - num;
        }
        return sum;
    }

    // Method to check whether a string is palindrome or not.
    public static boolean isPalindrome(String word)
    {
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while(start < end)
        {
            if(charArray[start] != charArray[end])
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

class Runner_2 {
    public static void main(String[] args) {
        ArrayUtil obj = new ArrayUtil();
        int[] dummyArray = {9,6,7,5,6,0,2,6,0,8};
        int[] sampleArray = {13,34,2,34,33,1};
        int[] demoArray = {8,0,6,2,0,6,5,7,6,9};

        // Print the original array
        System.out.print("Dummy Array: ");
        obj.printArray(dummyArray);

        // Remove even numbers and print the resulting array
        System.out.print("Dummy Array after removing even elements: ");
        int[] arrayResultWithoutEven = ArrayUtil.removeEven(dummyArray);
        obj.printArray(arrayResultWithoutEven);

        // Remove odd numbers and print the resulting array
        System.out.print("Dummy Array after removing odd elements: ");
        int[] arrayResultWithoutOdd = ArrayUtil.removeOdd(dummyArray);
        obj.printArray(arrayResultWithoutOdd);

        // Reverse the array
        System.out.print("Reversed Array: ");
        ArrayUtil.reverseArray(dummyArray, 0, dummyArray.length-1);
        obj.printArray(dummyArray);

        // Minimum element in array
        System.out.print("Minimum element: ");
        System.out.println(ArrayUtil.findMinimum(dummyArray));

        // Maximum element in array
        System.out.print("Maximum element: ");
        System.out.println(ArrayUtil.findMaximum(dummyArray));

        // Second maximum element in array
        System.out.print("Sample Array: ");
        obj.printArray(sampleArray);
        System.out.println("Second Max Element: "+ArrayUtil.findSecondMax(sampleArray));

        // Move zeroes to last
        System.out.print("Demo Array: ");
        obj.printArray(demoArray);
        obj.moveZeroesToLast(demoArray, demoArray.length);
        System.out.print("Demo Array after moving zeroes to the last: ");
        obj.printArray(demoArray);

        // Resize the array
        int[] original = {1,2,3,4,5,6,7,8,9,0};
        System.out.println("The size of original array: "+original.length);
        original = ArrayUtil.resizeArray(sampleArray, 20);
        System.out.println("The size of the original array after resize: "+original.length);
        int[] myArray = {1,2,3,5,6,7,8,9};
        obj.printArray(myArray);
        int missingNum = ArrayUtil.findMissingNum(myArray);
        System.out.print("");
        System.out.print("The missing number in above array is: "+missingNum);
        boolean checkPalindrome = ArrayUtil.isPalindrome("MADAM");
        System.out.println(" ");
        System.out.println(checkPalindrome);
    }
}
