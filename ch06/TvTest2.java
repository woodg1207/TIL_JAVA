
public class TvTest2 {
    public static void main (String[] args){
        Tv t1 = new Tv(); //TvTest에 Tv 클래스가 정의 돼있어서 가능
        Tv t2 = new Tv();
        System.out.println("t1 channel == "+t1.channel);
        System.out.println("t2 channel == "+t2.channel);
        t1.channel = 7;
        System.out.println("t1 channel == "+t1.channel);
        
    }
}
