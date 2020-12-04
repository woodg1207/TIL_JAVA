public class FactorialTest {
    public static void main (String[] args) {
        int result = factorial(4);
        System.out.println(result);
    }

    static int factorial(int n) {
        int result = n;
        if (n==0){
            return 1;
        }
        else{
            result *= factorial(n-1);
        }
        return result;
    }
}
