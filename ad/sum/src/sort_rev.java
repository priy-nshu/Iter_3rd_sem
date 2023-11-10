public class sort_rev {
    public static boolean rev(int arr[])
    {

        int c=-1,c1=-1,n= arr.length,i;
        for (i=0;i<n;i++){
            if (arr[i]>arr[i+1]) {
                c = i;
                break;
            }
        }
        if (c==-1)
        {
            System.out.println("Sorted");
        }
        for (i=c;i<n-1;i++){
            if (arr[i] < arr[i+1])
            {
                c1++;
                break;
            }
        }
        if (c1==-1)
            return true;
        if (arr[c-1]>arr[c1] || arr[c1+1] < arr[c])
            return false;
        for (int j = c1+1; j < c-1; j++) {
            if (arr[j]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a[]={1,2,3,6,5,4,7};
        System.out.println(rev(a));
    }
}
