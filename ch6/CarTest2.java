public class CarTest2 {
    public static void main(String[] args){
        Car2 c1 = new Car2();
        Car2 c2 = new Car2("blue");
        System.out.println("c1.color : " + c1.color+", c1.gearType : "+c1.gearType+", c1.door : "+c1.door);
        System.out.println("c2.color : " + c2.color+", c2.gearType : "+c2.gearType+", c2.door : "+c2.door);
        // 생성자를 이용한 인스턴스의 복사
        Car2 c3 = new Car2(c1);
        System.out.println("c3.color : " + c3.color+", c3.gearType : "+c3.gearType+", c3.door : "+c3.door);
        
    }
}
class Car2 {
    String color;
    String gearType;
    int door;
    Car2(){
        this("White", "auto", 4);
    }
    Car2(String color){
        this(color, "auto", 4);
    }
    Car2(String color, String gearType, int door){
        // color = c;
        // gearType = gt;
        // door = d;
        // this를 사용하면 인스턴스 변수를 지칭하게 된다. 
        this.color = color;
        this.gearType = gearType;
        this.door = door;
        
    }
    // 생성자를 이용한 인스턴스의 복사
    Car2(Car2 c){
        
        // this.color = c.color;
        // this.door = c.door;
        // this.gearType = c.gearType;
        //위의 방법 보다 
        this(c.color, c.gearType, c.door);//이 방법이 간략하고 좋음
    }
}