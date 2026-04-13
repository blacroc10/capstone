//multithreading with synchronization
//normal sync, method level sync, block level sync, static level sync


//in single threading output is the same all the time

//differences between multiprocessing, multitasking and multithreading:
//multiprocessing: multiple processes running simultaneously, each process has its own memory space
//multitasking: multiple tasks running simultaneously, can be achieved through multiprocessing or multithreading
//multithreading: multiple threads running simultaneously within a single process, threads share the same memory

// step 1: import java.lang package.
// step 2: A) by extending the thread class
//         B) by implementing the runnable interface (best approach in the real world)
// step 3: initialize the run() method
// step 4: give the public access to the run() method
// step 5: implement the run() method (most important method)
// step 6: create the number of threads.
// step 7: start all the threads.

class singleT601 extends Thread {
    public void run(){
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Bye SIT");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
        }

    }
}
public class SIT_601 {
    public static void main(String[] args) {
        singleT601 obj = new singleT601();
        obj.start();
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Hello SIT");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
        }

    }
}