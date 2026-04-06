//infosys question
import java.util.*;
public class SIT_105 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] A=new int[n];
        System.out.println("\nEnter the elements of the array");
        for(int i=0;i<n;i++){
            System.out.println("Enter "+ (i+1) + " Element: ");
            A[i]=sc.nextInt();
        }
        System.out.println("\nEnter Total Queries: ");
        int query = sc.nextInt();
        int totalSum = 0;
        for(int q=1; q<=query;q++){
            System.out.println("\nEnter the type of " + q + " query: ");
            int type=sc.nextInt();
            System.out.println("Enter the starting index of the " +q+ " query: ");
            int L = sc.nextInt();
            System.out.println("Enter the ending index of the " +q+ " query: ");
            int R = sc.nextInt();

            if(type == 1){ //replace the array from L to r
                for(int i=L; i<=R; i++){
                    A[i]=((i-L+1)*A[L]);
                }
            }
            else if(type == 2){ // sum of the array from L to r
                int sum = 0;
                for(int i=L; i<=R; i++){
                    sum += A[i];
                }
                totalSum += sum;
                
                System.out.println("Sum of elements from index " + L + " to " + R + " is: " + sum);
            }
            else{
                System.err.println("Invalid query.");
                
            }
        }
        System.out.println("Total Sum of all type 2 queries: " + totalSum);
        sc.close();

    }
}
