
public class ReferenceParamEx3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i=0; i<5; i++){
            arr[i] = 6-i;
        }

        printArr(arr);
        sortArr(arr);
        printArr(arr);
        System.out.println("sum : "+sumArr(arr));
        
    }

    static void printArr(int[] a){
        System.out.print("[ ");
        for (int i : a){
            System.out.print(i+ ", ");
        }
        System.out.println("]");
    }

    static void sortArr(int[] a){
        int tmp;
        for (int i=0; i<a.length-1;i++){
            for (int j=0; j<a.length-1-i;j++ ){
                if (a[j] > a[j+1]){
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp; 
                }
            }
        }
    }

    static int sumArr(int[] a){
        int sum = 0;
        for (int i: a){
            sum += i;
        }
        return sum;
    }
}
