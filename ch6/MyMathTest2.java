public class MyMathTest2 {
    public static void main(String[] args){
        // 클래스 메서드는 바로 사용가능.
        System.out.println(MyMath2.add(2L, 4L));
        System.out.println(MyMath2.subtract(2L, 4L));
        System.out.println(MyMath2.multiply(2L, 4L));
        System.out.println(MyMath2.divide(2L, 4L));

        // 인스턴스를 생성해야 가능.
        MyMath2 mm = new MyMath2();
        mm.a = 2L;
        mm.b = 4L;
        System.out.println(mm.add());
        System.out.println(mm.subtract());
        System.out.println(mm.multiply());
        System.out.println(mm.divide());
    }
}

class MyMath2{
    long a, b; // 인스턴스 변수
    
    // 인스턴스 메소드는 인스턴스 변수를 사용하기 때문에 매개변수가 필요없음
    // 인스턴스를 생성했을 때에만 사용이 가능함.
    long add(){return a+b;}
    long subtract() {return a-b;}
    long multiply() {return a*b;}
    double divide() { return (double)a/(double)b;}

    static long add(long a, long b) {return a+b;}
    static long subtract(long a, long b) {return a-b;}
    static long multiply(long a, long b) {return a*b;}
    static double divide(double a, double b) {return a/b;}

}