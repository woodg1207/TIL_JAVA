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

## 2. 오버라이딩

### 오버라이딩

- 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것을 오버라이딩이라고 한다. 상속받은 메서드를 그대로 사용하기도 하지만, 자손 클래스 자신에 맞게 변경해야하는 경우가 많다. 
- 이렇 때 조상의 메서드를 `오버라이딩`이라 한다. 

### 오버라이딩 조건

- 자손 클래스에서 `오버라이딩`하는 메서드는 조상 클래스의 메서드와
  - 이름이 같아야 한다.
  - 매개변수가 같아야 한다.
  - 반환타입이 같아야 한다.

- 선언부가 서로 일치해야 한다는 것을 의미
  - 다만, 접근 제어자(access modifier) 와 예외(exception)는 제한된 조건 하에서만 다르게 변경할 수 있다.

1. 접근 제어자는 조상 클래스의 메서드보다 **좁은 범위로 변경 할 수 없다**. 
   - 조상 클래스에서 정의된 메서드의 접근 제어자가 `protected`라면, 이를 오버라이딩하는 자손 클래스의 메서드는 접근 제어자가 `protected`나 `public`이어야 한다. 
   - 대부분의 경우 같은 범위의 접근 제어자를 사용한다. 
   - 접근범위를 넓은 것에서 좁은 순으로 나열하면 `public, protected, (default), private`이다. 
2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.



- 조상 클래스의 메서드를 자손 클래스에서 오버라이딩할 때
  1. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
  2. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
  3. 인스턴스메서드를 `static`메서드로 또는 그 반대로 변경할 수 없다.

- 조상 클래스에서 정의된 `static`메서드를 자손 클래스에서 똑같은 이름의 `static`메서드로 정의가능한가?
  - 가능하다.
  - 이것은 각 클래스의 `static`메서드를 정의하는 것일 뿐 `오버라이딩`이 아니다.
  - 호출 할때는 `클래스이름.메서드이름()`으로 호출하는것이 바람직하다.
  - `static`멤버들은 각 클래스에 묶여 있다고 생각해야함.

### 오버로딩 VS 오버라이딩

- 오버로딩 : 기존에 없는 새로운 메서드를 정의함 `new`
- 오버라이딩 : 상속받은 메서드의 내용을 변경하는 것 `change, modify`

```java
class Parent {
    void parentMethod() {}
}
class Child extends Parent{
    void parentMethod() {}//오버라이딩
    void parentMethod(int i) {} //오버로딩
    
   	void childMethod() {}
    void childMethod(int i) {} // 오버로딩
    void childMethod() {} // error. 메서드 중복정의
}
```



### super

- `super`는 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수이다.
- 멤버변수와 지역변수의 이름이 같을 때 `this`를 사용한 것 처럼
- 상속받은 멤버변수와 자신의 멤버와 이름이 같을 때 `super`를 붙여 구별한다.

- `super`를 사용하지 않고 `this` 를 사용해도 된다. 하지만 조상과 자손이 중복이 된다면 `super`를 사용한다.
- `this`와 마찬가지로 `static`메서드에서는 사용할 수 없다.  `인스턴스`메서드에서만 사용 가능하다.

```java
public class SuperTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    }
}

class Parent {
    int x = 10;
}

class Child extends Parent {
    int x = 20;
    void method() {
        System.out.println("x = " +x);
        System.out.println("this.x = " +this.x);
        System.out.println("super.x = " +super.x);

    }
}
/*
x = 20
this.x = 20
super.x = 10
```

### super()

- 조상 클래스의 생성자

**Object클래스를 제외한 모든 클래스의 생성자 첫 줄에 생성자, this() 또는 super()를 호출해야 한다. 그렇지 않으면 컴파일러가 자동적으로 `super();`를 생성자의 첫 줄에 삽입한다. **



## 3. package와 import

### 패키지

- 클래스의 묶음

**클래스가 물리적으로 하나의 클래스파일(.class)인 것과 같이 패키지는 물리적으로 하나의 디렉토리이다.**

- 하나의 소스파일에는 첫 번째 문장으로 단 한 번의 패키지 선언만을 허용한다.
- 모든 클래스는 반드시 하나의 패키지에 속해야한다. 
- 패키지는 점(.)을 구분자로 하여 계층구조로 구성할 수 있다.
- 패키지는 물리적으로 클래스 파일(.class)을 포함하는 하나의 디렉토리이다.

### import

소스파일의 구성은 

1. `package`
2. `import`
3. 클래스 선언

```java
import java.text.SimpleDateFormat;
import java.util.Date;
public class ImportTest {
    public static void main(String[] args) {
        Date today = new Date();

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

        System.out.println("오늘 날짜는 "+date.format(today));
        System.out.println("현재 시간은 "+time.format(today));
    }
}
```

### static import

`import`문을 사용하면 클래스의 패키지명을 생략할 수 있는 것과 같이 `static import`문을 사용하면 `static`멤버를 호출할 때 클래스 이름을 생략할 수 있다.

```java
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ImportTest {
    public static void main(String[] args) {
        Date today = new Date();

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

        println("오늘 날짜는 "+date.format(today));
        println("현재 시간은 "+time.format(today));
    }
}
```

## 4. 제어자(modifier)

1권 344page

### static

- 클래스 변수(static 멤버변수)
- 멤버변수, 메서드, 초기화 블럭에서 사용 : 클래스에 관계된 것이기 때문에 인스턴스를 생성하지 않고도 사용.
- static메서드 내에서 인스턴스멤버를 직접 사용할 수 없다.

### final

- 클래스, 메서드, 멤버변수, 지역변수에서 사용
  - 변수에 사용되면 값을 변경할 수 없는 상수가 되고
  - 메서드에 사용되면 오버라이딩을 할수 없게 되고
  - 클래스에서 사용되면 자손클래스를 정의할 수 없게 된다.

### abstract

- 클래스, 메서드에서 사용
- 미완성에서 사용하거나 클래스에서 인스턴스를 생성 못하도록 할 경우

## 5. 접근 제어자





