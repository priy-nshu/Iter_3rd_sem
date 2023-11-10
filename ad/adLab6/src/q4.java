import java.util.Scanner;

public class q4 {
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
    public static void diff1(int arr[]) {
        int a=arr[0], b=arr[1], d=Math.abs((a-b));
        for (int i = 2; i < arr.length-1; i++) {
            for (int j = 3; j < arr.length; j++) {
                if (d>Math.abs((arr[i]-arr[j]))){
                    d=Math.abs((arr[i]-arr[j]));
                    a=arr[i];
                    b=arr[j];
                }
            }
        }
        System.out.print("Min diff ="+a+","+b);
        System.out.println(" with diff ="+d);
    }
    public static void diff2(int arr[]) {
        int a=arr[0], b=arr[1], d=Math.abs((a-b));
        for (int i = 2; i < arr.length-1; i++) {
            for (int j = 3; j < arr.length; j++) {
                if (d<Math.abs((arr[i]-arr[j]))){
                    d=Math.abs((arr[i]-arr[j]));
                    a=arr[i];
                    b=arr[j];
                }
            }
        }
        System.out.print("Max diff ="+a+","+b);
        System.out.println(" with diff ="+d);
    }
    public static void main(String[] args) {
        q4 x= new q4();
        int a[]=x.insert();
        x.diff1(a);
        x.diff2(a);
    }
}
