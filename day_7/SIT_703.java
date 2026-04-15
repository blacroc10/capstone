//multithreading server
class BlockSynch_703 { // application Synchronization
    int available = 10;

    void booking(int seat) {
        System.out.println("Hello: " + Thread.currentThread().getName());
        System.out.println("Hello: " + Thread.currentThread().getName());
        System.out.println("Hello: " + Thread.currentThread().getName());
        synchronized (this) {
            String name = Thread.currentThread().getName();
        if (available >= seat) {
            System.out.println("seats are booked : " + name + "----------------------");
            available = available - seat;
            System.out.println("Remaining seats: " + available + "----------------------");

        } else {
            System.out.println("Seats not available for: " + name + "----------------------");
            System.out.println("Requested: " + seat + " Available: " + available + "----------------------");
        }
            
        }

    }

}

public class SIT_703 extends Thread {
    int seat;
    BlockSynch_703 op;

    public SIT_703(BlockSynch_703 op, int seat) {
        this.op = op;
        this.seat = seat;
    }

    public void run() {
        op.booking(seat);

    }

    public static void main(String[] args) {
        BlockSynch_703 op = new BlockSynch_703();
        SIT_703 t1 = new SIT_703(op, 5);
        SIT_703 t2 = new SIT_703(op, 6);

        t1.setName("Onkar");
        t2.setName("Alankar");
        t1.start();
        t2.start();
    }

}
