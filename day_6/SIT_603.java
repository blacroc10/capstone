//online calculator; print the tables; method level sync
//t1 and t2
//t1 wants the tables of 5 and t2 wants the tables of 7  
class tableSIT{
    synchronized void printTable(int n){
        for(int i = 1; i <= 10; i++){
            System.out.println(i*n);
        }
    }
} //synchronization
class fiveSIT extends Thread{
    tableSIT F;
    public fiveSIT(tableSIT f) {
        F=f;
    }
    
    public void run(){
        F.printTable(5);
    }
} //multithreading
class sevenSIT extends Thread{
    tableSIT S;
    public sevenSIT(tableSIT s){
        S=s;
    }
    public void run(){
        S.printTable(7);
    }
} //multithreading
public class SIT_603 {
    public static void main(String[] args) {
        tableSIT op = new tableSIT(); //application

        //threads
        fiveSIT t1 = new fiveSIT(op);
        sevenSIT t2 = new sevenSIT(op);
        t1.start();
        t2.start();   
    }    
}
                    