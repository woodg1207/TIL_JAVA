public class ReferenceParamEx2 {
    public static void main(String[] args){
        int[] x = {10};
        System.out.println(x[0]);

        change(x);
        System.out.println(x[0]);
    }

    static void change(int[] a){ // class 만들 시간 없을 때. 임시적으로 만들때
        a[0] = 1000;
        System.out.println("change to : "+a[0]);
    }
}
