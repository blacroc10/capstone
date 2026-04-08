//Worst case time complexity: O(n^2)
public class SIT_301 {

    public static void main(String[] args) {
        int n = 40;
        for (int i = 2; i <= n; i++){ //2 ---> n
            System.out.println(i+ " : "+ isPrime(i));
        }
        
    }
    static boolean isPrime(int num){
        int c = 2;
        while(c < num){
            if(num % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}
