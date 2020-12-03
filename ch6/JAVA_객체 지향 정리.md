[toc]



# JAVA_객체 지향 정리

## 1. 클래스와 객체

1. 클래스 (class)
   - 정의 : 객체를 정의해 놓은것
   - 용도 : 객체를 생성하는데 사용
2. 객체
   - 정의 : 실제로 존재하는 것, 사물 또는 개념
   - 용도 : 객체가 가지고 있는 기능과 속성에 따라 다름

| 클래스      | 객체   |
| ----------- | ------ |
| 제품 설계도 | 제품   |
| TV 설계도   | TV     |
| 붕어빵 기계 | 붕어빵 |

객체를 만드는 과정을 `인스턴스화`라고 한다.

클래스로 부터 만들어진 객체를 `인스턴스`



책상은 인스턴스다 -> 책상은 `객체`다

책상은 책상클래스의 객체다 -> 책상은 책상클래스의 `인스턴스`다

- 의미는 같지만 문맥상 다르게 쓰기.

### 객체의 구성요소

1. 속성
   - 멤버변수, 특성, 필드, 상태
2. 기능
   - 메서드, 함수, 행위

- 객체는 속성과 기능의 집합
- 속성과 기능은 객체의 멤버.

 

### 인스턴스와 참조 변수

인스턴스와 참조 변수는 TV와 TV리모콘과 같은 관계이다. : 참조변수를 통해 인스턴스를 다루기때문

```java
Tv t; //참조변수 t선언
t= new Tv(); // 인스턴스 생성
```

- 인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치 해야 한다. 



### java 예제 정리

```java
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
```

```java
public class TvTest3 {
    public static void main(String[] args){
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        t2 = t1; // t1이 저장하고 있는 값(주소)을 t2에 저장.
        //t2가 참조하던 인스턴스는 더 이상 사용할 수 없음.
        //t1의 인스턴스를 참조하게 된다.
        t1.channel = 8;
		// t1.channel, t2.channel == 8
        // 하나의 인스턴스를 여러개의 참조변수가 참조할 수 있다
        // 하나의 참조변수는 여러개의 인스턴스를 참조할 수 없다.

    }
}
```



### 객체 배열

```java
public class TvTest4 {
    public static void main(String[] args){
        // 배열은 조금 다르다.
        //1
        Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv 타입의 참조배열 변수
        for (int i=0; i<tvArr.length;i++) {
            tvArr[i] = new Tv(); // 객체를 생성해서 각 배열에 저장.
            // 추가적인 내용은 다형성 배울때 알게 됨.
            tvArr[i].channel = i + 10;
        }
        //2
        /*
        Tv[] tvArr = new Tv[3];
        tvArr[1] = new Tv();
        tvArr[2] = new Tv();
        tvArr[3] = new Tv();
        */
        //3
        // Tv[] tvArr = {new Tv(), new Tv(), new Tv()};
        for (int i = 0; i<tvArr.length;i++){
            tvArr[i].channelUp();
            System.out.printf("%d : %d%n", i, tvArr[i].channel);

        }
    }
}

```

### 클래스의 또 다른 정의

242page

1. 변수 : 하나의 데이터를 저장할 수 있는 공간
2. 배열 : 같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간
3. 구조체 : 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간
4. 클래스 : 데이터와 함수의 결합 (구조체 + 함수)



## 2. 변수와 메서드

### 선언 위치에 따른 변수의 종류

```java
class Variables {
    int iv; // 인스턴스 변수 | 클래스 영역
    static int cv; // 클래스 변수 (static변수, 공유 변수) | 클래스 영역
    void method() {
        int lv = 0; //지역변수 | 메서드 영역
    }
}
```

- 인스턴스 변수 : 인스턴스가 생성되었을 때
  - 독립적인 저장공간을 가짐. 인스턴스마다 고유한 상태를 유지해야하는 경우 선언
- 클래스 변수 : 클래스가 메모리에 올라갈 때
  - `static`을 사용하여 선언.
  - 모든 인스턴스가 저장공간(변수)을 공유한다.
  - 모든 인스턴스들이 공유한 값을 유지 해야하는 경우에 사용 된다.
  - 인스턴스를 생성하지 않아도 바로 사용할 수 있음
    - `클래스이름.클래스변수` 형식으로 사용된다. ex) `Variables.cv`
  - 클래스가 메모리에 `로딩`될 때 생성, 프로그램이 종료될 때 까지 유지.
  - `public`을 앞에 붙이면 같은 프로그램내 어디서나 접근 할 수있는 `전역 변수`의 성격을 갖는다.

- 지역 변수 :  변수 선언문이 수행되었을 때
  - 메서드 내에서 만 사용가능
  - 메서드 종료시 소멸
  - `for` or `while`에서 선언된 변수의 경우 `{}`안에서만 있고 없어짐.	

`Card class`

```java
class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 250;
}
```



```java
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
        //클래스 변수가 변경되는 것을 확인 할 수 있음.
        // Card.height를 사용해서 변경하는게 좋다 // 인스턴스 변수로 착각할 수 있기 때문
        System.out.println("c1 info kind & number :" + c1.kind + ", " + c1.number + "card size w * h" + c1.width + " * " + c1.height);
        System.out.println("c2 info kind & number :" + c2.kind + ", " + c2.number + "card size w * h" + c2.width + " * " + c2.height);

    }
}
```

```java
//result
100
250
c1 info kind & number :H, 7card size w * h100 * 250
c2 info kind & number :S, 4card size w * h100 * 250
card size change
c1 info kind & number :H, 7card size w * h30 * 50
c2 info kind & number :S, 4card size w * h30 * 50
```

### 메서드

- 사용하는 이유
  - 높은 재사용성
  - 중복된 코드 제거
  - 프로그램의 구조화