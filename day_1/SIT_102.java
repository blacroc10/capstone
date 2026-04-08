//Q: A Payment Gateway System an e-commerce website uses
// * UPI Payment
// * Card Payment
//Both have processPayment() method
//A HybridPaymentSystem supports both.

import java.util.Scanner;

interface UPIPayment{
    default void processPayment(){
        System.out.println("Payment done using UPI.");
    }
}
interface CardPayment{
    default void processPayment(){
        System.out.println("Payment done using Card.");
    }
}

class HybridPaymentSystem implements UPIPayment,CardPayment{

    Scanner sc = new Scanner(System.in);
    @Override
    public void processPayment(){
        System.out.println("Choose Payment Mode: ");
        System.out.println("\nChoice 1: UPI Payment");
        System.out.println("Choice 2: Card Payment");
        System.out.println("\nChoice: ");
        int ch = sc.nextInt();

        if (ch==1) {
            UPIPayment.super.processPayment();
        }
        else if (ch==2){
            CardPayment.super.processPayment();
        }
        else{
            System.err.println("Invalid Choice");
        }
    }
}

public class SIT_102 {
    public static void main(String[] args) {
        HybridPaymentSystem op=new HybridPaymentSystem();
        while(true){
            op.processPayment();
        }

        
    }
    
}
