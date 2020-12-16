// package ch6; vscode 시작위치에 따라서 다름

class Tv {
    // Tv의 속성( 멤버 변수 )
    String color;
    boolean power;
    int channel;
    // Tv의 기능(메서드)
    void power() {power = !power;}
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}
public class TvTest {
    public static void main(String[] args) {
        Tv t; //참조변수 t선언
        t= new Tv(); // 인스턴스 생성
        t.channel = 7;
        t.channelDown();
        System.out.println("현재 채널은"+t.channel+"입니다.");
    }
}