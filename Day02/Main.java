import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        CircularQueue cq = new CircularQueue(5);
        QuickSortStrings qs = new QuickSortStrings();
        BST bst = new BST();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Circular Linked List");
            System.out.println("2. Circular Queue");
            System.out.println("3. Quick Sort Strings");
            System.out.println("4. Binary Search Tree");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("1) Insert  2) Delete  3) Modify  4) Display");
                    int opt = sc.nextInt();
                    if (opt == 1) {
                        System.out.print("Enter data & position: ");
                        int d = sc.nextInt(), p = sc.nextInt();
                        cll.insert(d, p);
                    } else if (opt == 2) {
                        System.out.print("Enter data to delete: ");
                        int d = sc.nextInt();
                        cll.delete(d);
                    } else if (opt == 3) {
                        System.out.print("Enter old and new data: ");
                        int o = sc.nextInt(), n = sc.nextInt();
                        cll.modify(o, n);
                    } else cll.display();
                    break;

                case 2:
                    System.out.println("1) Enqueue  2) Dequeue  3) Display");
                    int qopt = sc.nextInt();
                    if (qopt == 1) {
                        System.out.print("Enter value: ");
                        cq.enqueue(sc.nextInt());
                    } else if (qopt == 2)
                        cq.dequeue();
                    else
                        cq.display();
                    break;

                case 3:
                    System.out.print("Enter number of strings: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    String[] arr = new String[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter string " + (i + 1) + ": ");
                        arr[i] = sc.nextLine();
                    }
                    qs.quickSort(arr, 0, n - 1);
                    System.out.println("Sorted Strings:");
                    for (String s : arr)
                        System.out.println(s);
                    break;

                case 4:
                    System.out.println("1) Add Node  2) Remove Node  3) Display");
                    int bopt = sc.nextInt();
                    if (bopt == 1) {
                        System.out.print("Enter value: ");
                        bst.add(sc.nextInt());
                    } else if (bopt == 2) {
                        System.out.print("Enter value to delete: ");
                        bst.remove(sc.nextInt());
                    } else
                        bst.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}