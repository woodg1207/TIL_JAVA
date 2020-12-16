public class DocumentTest {
    public static void main(String[] args){
        Document d1 = new Document();
        Document d5 = new Document();
        Document d4 = new Document();
        Document d3 = new Document("java.txt");
        Document d2 = new Document();
    }
}
class Document{
    static int cnt = 0;
    String name;
    Document(){ //제목이 없는 경우
        this("제목없음"+ ++cnt);
    }
    Document(String name){
        this.name = name;
        System.out.println("문서 "+this.name+"가 생성 되었습니다.");
    }
}