import java.util.Scanner;

public class q3 {
    public static void findMissing(int arr[])
    {
        int i,N=arr.length;
        int temp[] = new int[N + 1];
        for (i = 0; i <= N; i++) {
            temp[i] = 0;
        }

        for (i = 0; i < N; i++) {
            temp[arr[i] - 1] = 1;
        }

        int ans = 0;
        for (i = 0; i <= N; i++) {
            if (temp[i] == 0)
                ans = i + 1;
        }
        System.out.println(ans);
    }
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
    public static void main(String[] args) {
        q3 x=new q3();
        int a[]=x.insert();
        x.findMissing(a);
    }
}
