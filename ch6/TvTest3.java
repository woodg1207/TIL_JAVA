public class TvTest3 {
    public static void main(String[] args){
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println(t1.channel);
        System.out.println(t2.channel);
        System.out.println("ㅇㅇ");
        t2 = t1;// t1이 저장하고 있는 값(주소)을 t2에 저장.
        //t2가 참조하던 인스턴스는 더 이상 사용할 수 없음.
        //t2는 t1의 인스턴스를 참조하게 된다.
        t1.channel = 8;
        System.out.println(t1.channel);
        System.out.println(t2.channel);
        // 하나의 인스턴스를 여러개의 참조변수가 참조할 수 있다
        // 하나의 참조변수는 여러개의 인스턴스를 참조할 수 없다.
        t2.channelDown();
        System.out.println(t1.channel);
        System.out.println(t2.channel);

    }
}
