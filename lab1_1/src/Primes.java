import  java.util.Scanner;

public class Primes {

    public static void IsPrime(int n){
        boolean isTrue = true;
        for (int i = 2; i < n; i++){
            if (n % i == 0){
                isTrue = false;
            }
        }
        if (isTrue == true){
            System.out.println(n);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n;
        for (int i = 3; i < 100; i++) {
            n = i;
            IsPrime(n);
        }
    }

}
