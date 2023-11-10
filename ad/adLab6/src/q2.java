import java.util.Scanner;

public class q2 {
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-1; j++) {
                if (i!=j) {
                    if (arr[i] == arr[j]) {
                        System.out.println("the repeated number=" + arr[j]);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        q2 x=new q2();
        int a[]=x.insert();
        x.repeat(a);
    }
}
