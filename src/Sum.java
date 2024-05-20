import java.util.Scanner;
public class Sum {
    public int getSum(int n){
        return (n*(n+1)/2);
    }
}

class Runner_1 {
    public static void main(String[] args) {
        System.out.print("Enter number n: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Sum obj = new Sum();
        System.out.println("Sum of first " + num + " natural numbers is : " + obj.getSum(num));
    }
}
