public class MyMathTest {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long r1, r2, r3;
        double r4;
        r1 = mm.add(3L, 5L);
        r2 = mm.multiply(3L, 5L);
        r3 = mm.subtact(3L, 5L);
        r4 = mm.divide(3L, 5L);//long 애서 double로 자동 형변환

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}

class MyMath {
    long add (long a, long b){
        long result = a+b;
        return result;
        // return a + b;
    }
    long subtact (long a, long b){return a-b;}
    long multiply (long a, long b) {return a*b;}
    double divide (double a, double b){ return a/b;}
}