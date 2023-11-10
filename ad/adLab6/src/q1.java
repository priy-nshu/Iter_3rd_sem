import java.util.Scanner;
public class q1 {

    public static int[] insert()
    {
        Scanner x= new Scanner(System.in);
        System.out.println("Enter you array length then array");
        int n=x.nextInt(),i;
        int arr[] = new int[n];
        for (i=0;i<n;i++)
        {
            arr[i]=x.nextInt();
        }
        return arr;
    }

    public static void repeat(int arr[]) {
        int a=0;
        for (int i = 0; i < arr.length; i++) {
            a=arr[i];
            for (int j = 0; j < arr.length-i; j++) {
                if (a==arr[j]){
                    System.out.println("the repeated number="+arr[j]);
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        q1 x=new q1();
        int a[]=x.insert();
        x.repeat(a);
    }
}
