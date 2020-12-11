class Car {
    String color;
    String gearType;
    int door;
    Car(){} //생성자.
    // 생성자에도 매개변수를 넣을수 있다.
    Car(String c, String gt, int d){
        color = c;
        gearType = gt;
        door = d;
    }
}
public class CarTest {
    public static void main(String[] args){
        Car c1 = new Car();
        c1.color = "red";
        c1.gearType = "auto";
        c1.door = 4;
        Car c2 = new Car("blue", "manual", 4);
        System.out.println("c1.color : " + c1.color+", c1.gearType : "+c1.gearType+", c1.door : "+c1.door);
        System.out.println("c2.color : " + c2.color+", c2.gearType : "+c2.gearType+", c2.door : "+c2.door);
    }
}
