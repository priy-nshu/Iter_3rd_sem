public class sorting {
    static void insertionsort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void selectionsort(int arr[]) {
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
    }

    static void bubbleSort(int arr[])
    {
        int i, j, temp;
        int n= arr.length;
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void printArray(int arr[])
    {
        int i,n= arr.length;
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr1[] = { 644, 344, 252, 125, 262, 119, 908 };
        selectionsort(arr1);
        System.out.println("Selection Sorted array: ");
        printArray(arr1);


        int arr2[] = { 644, 344, 252, 125, 262, 119, 908 };
        insertionsort(arr2);
        System.out.println("Insertion Sorted array: ");
        printArray(arr2);


        int arr3[] = { 644, 344, 252, 125, 262, 119, 908 };
        bubbleSort(arr3);
        System.out.println("Bubble Sorted array: ");
        printArray(arr3);
    }
}
