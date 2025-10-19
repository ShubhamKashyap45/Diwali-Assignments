import java.util.Scanner;

public class Day01_Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];


        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            arr[i] = sc.nextLine();
        }

        int maxLength = 0;


        for (String s : arr) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        System.out.println("Length of the longest string: " + maxLength);
        sc.close();
    }
}
