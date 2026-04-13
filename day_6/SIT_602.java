//bus booking, normal synchronization
class BusSIT_602 extends Thread {
    int available = 5;
    int seat;
    BusSIT_602(int passenger){
        seat = passenger;
    }
    @Override
    public synchronized void run(){
        String name = Thread.currentThread().getName();
        if (available >= seat){
            System.out.println(name+" Seat Booked");
            available = available - seat;
        }
        else {
            System.out.println(name+ " Seats not available");
        }
        
    }

}
public class SIT_602 {
    public static void main(String[] args) {
        BusSIT_602 obj = new BusSIT_602(2);

        //number of threads or users
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        Thread t3 = new Thread(obj);

        t1.setName("Shubhankar");
        t2.setName("Ankit");
        t3.setName("Shivam");


        t1.start();
        t2.start();
        t3.start();
        
    }
}
