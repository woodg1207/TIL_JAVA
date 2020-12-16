
public class CardTest {
    public static void main (String[] args){
        System.out.println(Card.width);
        System.out.println(Card.height);
        Card c1 = new Card();
        c1.kind = "H";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "S";
        c2.number = 4;

        System.out.println("c1 info kind & number :" + c1.kind + ", " + c1.number + "card size w * h" + c1.width + " * " + c1.height);
        System.out.println("c2 info kind & number :" + c2.kind + ", " + c2.number + "card size w * h" + c2.width + " * " + c2.height);
        
        System.out.println("card size change");
        c1.width = 30;
        c2.height = 50;
        // class 변수가 변경되는 것을 알 수 있음.
        // 좋은 방법은 아님 인스턴스 변수로 헷갈릴 수 있음
        // Card.height로 변경할 것.
        System.out.println("c1 info kind & number :" + c1.kind + ", " + c1.number + "card size w * h" + c1.width + " * " + c1.height);
        System.out.println("c2 info kind & number :" + c2.kind + ", " + c2.number + "card size w * h" + c2.width + " * " + c2.height);

    }
}

class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 250;
}