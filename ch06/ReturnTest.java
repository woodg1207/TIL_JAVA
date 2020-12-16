public class ReturnTest {
    public static void main(String[] args){
        ReturnTest sample = new ReturnTest();
        int result = sample.add(1,3);
        System.out.println(result);

        int[] result2 = {0};
        ReturnTest.add(1,4,result2);
        System.out.println(result2[0]);    
    }

    int add(int a, int b){ // 인스턴스 method
        return a+b;
    }

    static void add(int a, int b, int[] result){ // 클래스 method
        result[0] = a+b;
    }
}
