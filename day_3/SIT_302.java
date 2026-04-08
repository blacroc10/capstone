//Average case time complexity: O(n*sqrt(n))
public class SIT_302 {

    public static void main(String[] args) {
        int n = 40;
        for (int i = 2; i <= n; i++){ //2 ---> n
            System.out.println(i+ " : "+ isPrime(i));
        }
        
    }
    static boolean isPrime(int num){
        int c = 2;
        while(c * c <= num){ //c <= sqrt(num)
            if(num % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}