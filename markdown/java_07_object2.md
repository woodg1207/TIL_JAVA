[TOC]

# JAVA_객체지향정리2

## 1. 상속(Inheritance)

- 상속
  - 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것
  - 코드의 추가 및 변경에 용이함
- `class Child extends Parent{}`

- 생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다.
- 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.
  - 접근 제어자(access modifier)가 `private` 또는 `default`인 멤버들은 상속되지 않는다기보다 상속은 받지만 자손 클래스로부터 접근이 제한되는 것이다. 
- 자손 클래스의 인스턴스를 생성하면 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성된다.

```java
public class CaptionTvTest {
    public static void main(String[] args){
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        System.out.println(ctv.channel);
        ctv.channelUp();
        System.out.println("up : "+ctv.channel);
        ctv.displayCaption("Hello, World!!");
        ctv.caption = true;
        ctv.displayCaption("Hello, World!!");

    }
}
class Tv {
    boolean power;
    int channel;

    void power(){
        power = !power;
    }
    void channelUp(){
        ++channel;
    }
    void channelDown(){
        --channel;
    }
}

class CaptionTv extends Tv {
    boolean caption;
    void displayCaption(String text){
        if (caption){
            System.out.println(text);
        }
    }
}
```

