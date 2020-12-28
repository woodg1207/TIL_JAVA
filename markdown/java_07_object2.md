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



### 클래스간의 관계 : 포함관계

- 포함(Composite)관계
  - 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 뜻한다.

```java
class Circle{
    int x;
    int y;
    int r;
}
class Point{
    int x;
    int y;
}
//// composite을 사용하면
class Circle{
    Point c = new Point(); //원점.
    int r;
}
```



### 클래스간의 관계 결정하기

상속 or 포함

```java
class Circle{ // 포함
    Point c = new Point(); //원점.
    int r;
}
class Circle extends Point{ // 상속
    int r;
}
```

- 원(Circle)은 점(Point)이다. `Circle is a Point.` : 상속 관계
- 원(Circle)은 점(Point)을 가지고 있다. `Circle has a Point.` : 포함 관계

DrawShape.java

```java
public class DrawShape {
    public static void main(String[] args){
        Point[] p = {
            new Point(100,100),
            new Point(140,50),
            new Point(200, 100)
        };
        Triangle t = new Triangle(p);
        Circle c = new Circle(new Point(150, 150), 50);
        
        t.draw();
        c.draw();
    }
}

class Shape {
    String color = "black";
    void draw() {
        System.out.printf("[color=%s]%n",color);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Point(){
        this(0, 0);
    }
    String getXY() {
        return "("+x+", "+y+")";
    }
}
class Circle extends Shape {
    Point center;
    int r;

    Circle() {
        this(new Point(0, 0), 100);
    }
    Circle(Point center, int r){
        this.center = center;
        this.r = r;
    }
    void draw(){
        System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
    }
    
}
class Triangle extends Shape {
    Point[] p = new Point[3];
    Triangle(Point[] p) {
        this.p = p;
    }
    void draw() {
        System.out.printf("[p1=%s , p2=%s, p3=%s, color=%s]%n", p[0].getXY(),p[1].getXY(),p[2].getXY(), color);
    }
}
```

Circle is a Shape

Circle has a Point

### 단일 상속

C++과는 다르게 한 조상으로만 상속을 받을 수 있다.

```java
class TVCR extends TV, VCR{ // error가 발생한다. 조상은 하나만
    ...
}
```

- 다중 상속을 허용하면 여러 클래스로부터 상속을 받을 수 있기 때문에 복합적인 기능을 가진 클래스를 쉽게 구현할 수 있다.
- 하지만 클래스간의 관계가 복잡해지고, 서로 다른 클래스로부터 상속받은 멤버간의 이름이 같은 경우 구별할 수 있는 방법이 없다는 단점이 존재한다.
- 자바에서는 이러한 문제로 인해 다중 상속을 포기하고 단일 상속을 진행한다.

- TVCR.java

  ```java
  public class TVCR extends TV {
      VCR vcr = new VCR(); // VCR클래스를 포함시켜 사용한다.
      int counter = vcr.counter;
  
      void play() {
          vcr.play();
      }
      void stop() {
          vcr.stop();
      }
      void rew() {
          vcr.rew();
      }
      void ff() {
          vcr.ff();
      }
  }
  
  class TV {
      boolean power;
      int channel;
      void power() {power=!power;}
      void channelUp() {++channel;}
      void channelDown() {--channel;}
  }
  class VCR {
      boolean power;
      int counter = 0;
      void power() {power=!power;}
      void play() {}
      void stop() {}
      void rew() {}
      void ff() {}
  }
  ```

### Object 클래스

- 모든 클래스의 조상
- `Object`클래스는 모든 클래스의 상속 계층도에서 최상위 조상 클래스이다.

