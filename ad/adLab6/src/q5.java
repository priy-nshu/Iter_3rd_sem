import java.util.Scanner;

public class q5 {
    public static int max(int[] arr)
    {
        int maxcount = 0,n= arr.length;
        int element_having_max_freq = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxcount) {
                maxcount = count;
                element_having_max_freq = arr[i];
            }
        }

        return element_having_max_freq;
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
        q5 x= new q5();
        int a[]=x.insert();
        x.max(a);
    }
}
