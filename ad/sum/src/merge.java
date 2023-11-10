import java.util.Scanner;
public class merge {

   public static void selectionsort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        printArray(arr);
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
   public static void merge(int arr1[],int arr2[]){
        int arr3[]=new int[arr1.length+ arr2.length],j=arr1.length;
        for (int i=0;i< arr1.length;i++){
            arr3[i]=arr1[i];
        }

           for (int i=0;i<arr2.length;i++){
                arr3[j]=arr2[0];
                j++;
            }
        selectionsort(arr3);
    }

   public static void printArray(int arr[])
    {
        int i,n= arr.length;
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[]=insert();
        int arr2[]=insert();
        merge(arr1,arr2);
    }
}
