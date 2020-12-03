public class ReferenceParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println(d.x);
        pChange(d.x);
        System.out.println(d.x);
        System.out.println("reference change start");
        rChange(d);
        System.out.println(d.x);
    }   

    static void pChange(int x){ //기본형 매개변수 int 등의 자료형 변수
        // 기초변수는 메모리에 저장된다.
        x = 1000;
        System.out.println("pchange : "+ x);
    }

    static void rChange(Data a){ //참조형 매개 변수 int[]의 경우도 참조형 변수이다.
        // 참조형 매개 변수는 객체이다.
        // 주소값이 저장 된다. 
        a.x = 1000;
        System.out.println("rchange : " + a.x);
    }
}
class Data{ int x; }
