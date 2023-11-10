import java.util.Scanner;
public class Arr_reduct {
    static void insertionsort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int f = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > f) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = f;
        }
        red(arr);
    }
    static int[] insert()
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
    static void red(int arr[]) {
        int m = arr[0], i, c=0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i]-m>0)
            {
                m=-arr[i];
                c++;
                System.out.println("Element remaining after "+i+" turn is="+(arr.length-i));
            }
        }
        System.out.println("No of time ="+c);
    }

    public static void main(String[] args) {
        Arr_reduct a= new Arr_reduct();
       int arr[]= a.insert();
        a.insertionsort(arr);
    }
}
