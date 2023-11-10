import java.util.Scanner;
public class L_Search {
    public static int lwor(int arr[], int x)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    public static int bwor(int[] arr, int x)
    {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (x == arr[mid]) {
                return mid;
            }
            else if (x > arr[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static int lwr(int arr[], int size, int key)
    {
        if (size == 0) {
            return -1;
        }
        else if (arr[size - 1] == key) {

            return size - 1;
        }
        return lwr(arr, size - 1, key);
    }

   public static int bwr(int arr[], int l, int r, int x)
    {
        if (r >= l && l <= arr.length - 1) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return bwr(arr, l, mid - 1, x);

            return bwr(arr, mid + 1, r, x);
        }
        return -1;
    }
    public static int[] insert(){
        Scanner x= new Scanner(System.in);
        System.out.println("enter size of the array and then the array");
        int n= x.nextInt(),a[]=new int[n];
        for (int j = 0; j < n; j++) {
            a[j]=x.nextInt();
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner x= new Scanner(System.in);
        L_Search a= new L_Search();
        int n[]= a.insert();
        System.out.println("enter the no to be searched and which method to be searched in");
        System.out.println("1.Linear Search without recursion");
        System.out.println("2.Linear Search with recursion");
        System.out.println("3.Binary Search without recursion");
        System.out.println("4.Binary Search with recursion");
        int b=x.nextInt();
        int m=x.nextInt();
        switch (m){
            case 1:{
                int lor=a.lwor(n,b);
                    if (lor==-1)
                        System.out.println("Element not present");
                    else
                        System.out.println("Element at "+lor);
                    break;
            }
            case 2: {
                int bor = a.bwor(n, b);
                if (bor == -1)
                    System.out.println("Element not present");
                else
                    System.out.println("Element at "+bor);
                break;
            }
            case 3: {
                int lr = a.lwr(n,n.length, b);
                if (lr == -1)
                    System.out.println("Element not present");
                else
                    System.out.println("Element at "+lr);
                break;
            }
            case 4:{
                int br=a.bwr(n,n[0],n[n.length-1],b);
                if (br==-1)
                    System.out.println("Element not present");
                else
                    System.out.println("Element at "+br);
                break;
            }
            default:{
                System.out.println("You didn't pick a valid option");
                System.out.println("thank you for your tomfoolery");
                System.exit(0);
            }
        }
    }
}
