public class CallStackTest {
    public static void main(String[] args) {
        System.out.println("main start");
        firstMethod();
        System.out.println("main end");
    }
    static void firstMethod() {
        System.out.println("first start");
        secondMethod();
        System.out.println("first end");
    }
    static void secondMethod(){
        System.out.println("second start");
        System.out.println("second end");
    }
}
