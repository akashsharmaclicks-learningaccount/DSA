import java.util.Scanner;
public class Average {
    public float getAverage(int a, int b, int c) {
    int sum = a + b + c;
    return sum / 3;
    }
}
class Runner{
    public static void main(String[] args) {
        Average obj = new Average();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();
        System.out.println("Enter the third number: ");
        int num3 = sc.nextInt();
        System.out.print("Average : ");
        float average = obj.getAverage(num1, num2, num3);
        System.out.println("The average of " + num1 + ","  +num2+ " and " + num3 + " is : " + average);
    }
}
