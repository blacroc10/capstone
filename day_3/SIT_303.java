//Best case time complexity: O(n*log(log(n)))
public class SIT_303{
    public static void main(String[] args) {
       int n = 40;
       boolean[] prime = new boolean[n+1];
       sieve(n,prime); 
    }
    static void sieve(int num , boolean[] prime){
        for(int i=2;i*i<=num;i++){
            if(prime[i]==false){
                for(int j=i*i;j<=num;j+=i){
                    prime[j]=true;
                }
            }
        }
        System.out.println("Prime numbers up to "+num+":");
        for(int i=2;i<=num;i++){
            if(prime[i]==false){
                System.out.print(i+" ");
            }
        }
    }
}