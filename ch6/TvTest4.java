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
