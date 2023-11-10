import java.util.Scanner;
public class C2all {
    public static int sum(int n)
    {
       if (n<=1)
           return n;
        else
            return n+sum(n=n-1);

    }
    public static int min(int A[], int n) {
        if (n == 1)
            return A[0];
        else {
            return Math.min(A[n - 1], min(A, n - 1));

        }
    }
        public static int max(int A[], int n){
            if(n == 1)
                return A[0];
            else {
            return Math.max(A[n-1], max(A, n-1));
        }
    }
 public static int factorial(int num){
     if (num >= 1)
         return num * factorial(num - 1);
     else
         return 1;
 }
    static int fibo(int n)
    {
        if (n <= 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }
 public static int GCD(int n1,int n2){
     if (n2 != 0)
         return GCD(n2, n1 % n2);
     else
         return n1;
 }
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
//        System.out.println("enter a number");
//        int n=x.nextInt();
//        System.out.println(sum(n));
//            System.out.println("Enter array");
//            int n1=x.nextInt(),a[]=new int[n1];
//            for (int i=0;i<n1;i++)
//            {
//                a[i]=x.nextInt();
//            }
//        System.out.println(min(a,a.length));
//        System.out.println(max(a,a.length));
//        System.out.println("Enter factorial");
//        int num=x.nextInt();
//        System.out.println(factorial(num));
        System.out.println("Enter nth number");
        int f = x.nextInt();
        System.out.println(fibo(f - 1));
        System.out.println("enter for gcd");
        int n1 = x.nextInt(), n2 = x.nextInt();
        System.out.println(GCD(n1, n2));
    }
    }


