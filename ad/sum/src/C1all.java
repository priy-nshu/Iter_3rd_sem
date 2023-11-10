import java.util.*;
public class C1all {
    public static void min_max()
    {

        Scanner x=new Scanner(System.in);
        System.out.println("Enter array size" );
        int n=x.nextInt();
        int arr[]=new int[n];
        System.out.println("enter array");
       for(int i=0;i<n;i++)
       {
         arr[i]=x.nextInt();
       }
       int max=arr[0],min=arr[0];
        for(int i=1;i<n;i++)
        {
           if(max<arr[i])
               max=arr[i];
           if(min>arr[i])
               min=arr[i];
        }
        System.out.println(max+" "+min);
        System.out.println();

    }
    public static void factorial()
    {

        System.out.println("enter no");
        Scanner x=new Scanner(System.in);
        int n=x.nextInt(),f=1;
        for (int i=1;i<=n;i++)
        {
            f=f*i;
        }
        System.out.println("fac= "+f);
        System.out.println();

    }
    public static void fibo()
    {
        System.out.println("enter no");
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        int a=0,b=1,c = 0;
        for (int i=2;i<n;i++)
        {
            c=a+b;
            a=b;
            b=c;
        }
        System.out.println("nth fibo is= "+c);
        System.out.println();
    }
    public static void rotate()
    {
        Scanner x=new Scanner(System.in);
        System.out.println("enter the rotated kth location,size and array ");
        int d=x.nextInt();
        int n=x.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++)
        {
           arr[i]=x.nextInt();
        }

                int temp[] = new int[n];

                int k = 0;
                for (int i = d; i < n; i++) {
                    temp[k] = arr[i];
                    k++;
                }
                for (int i = 0; i < d; i++) {
                    temp[k] = arr[i];
                    k++;
                }
                for (int i = 0; i < n; i++) {
                    arr[i] = temp[i];
                }
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
            }


    public static void main(String[] args) {
       C1all c1all =new C1all();
        C1all.min_max();
        C1all.factorial();
        C1all.fibo();
       c1all.rotate();
    }
}
