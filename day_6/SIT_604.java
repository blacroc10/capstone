//bank application
public class SIT_604 implements Runnable {
    int balance = 5000;
    int withdraw;

    SIT_604(int withdraw) {

        this.withdraw = withdraw;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread name: " + name);

        if (balance >= withdraw) {

            System.out.println("Withdrawn amount: " + withdraw);
            balance = balance - withdraw;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {
        SIT_604 obj = new SIT_604(2000);
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);
        t1.setName("Onkar");
        t2.setName("Alankar");
        t3.setName("Shubhankar");
        t1.start();
        t2.start();
        t3.start();
    }
}
