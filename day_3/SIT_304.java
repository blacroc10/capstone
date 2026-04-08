public class SIT_304 {
    public static void main(String[] args) {
        int n = 4; //number of disks
        play(n, 'A', 'C', 'B'); //A is source, C is destination, B is helper
    }
    static void play(int n, char source, char destination, char helper){
        if (n==1) {
            System.out.println("Move disk 1 from "+source+" to "+destination);
            return;
        }
        //first recursion is for n-1 disks
        play(n-1, source, helper, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        play(n-1, helper, destination, source);
    }
}
