package Array;

public class ArrayUtil {
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
class Runner_2{
    public static void main(String[] args) {
        ArrayUtil obj = new ArrayUtil();
        int[] dummyArray = {1,2,3,4,5,6,7,8,9};
        obj.printArray(dummyArray);
    }
}
