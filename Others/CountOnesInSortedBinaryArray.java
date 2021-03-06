package Others;

public class CountOnesInSortedBinaryArray {
    int countOnes(int arr[], int l, int h) {
        while(l < h) {
            int mid = l + (h-l) / 2;
            if((mid == h || arr[mid+1] == 0) && arr[mid] == 1)
                return mid+1;
            else if(arr[mid] == 1)
                l = mid+1;
            else 
                h = mid-1;
        }
        return 0;
    }

    public static void main(String args[])
    {
        CountOnesInSortedBinaryArray ob = new CountOnesInSortedBinaryArray();
        int arr[] = { 1, 1, 1, 1, 0, 0, 0 };
        int n = arr.length;
        System.out.println("Count of 1's in given array is "
                           + ob.countOnes(arr, 0, n - 1));
    }
}
