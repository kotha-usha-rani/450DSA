//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long merge(long[] arr, int start, int mid, int end){
        int i=start, j=mid+1, k=0;
        long count = 0 ;
        long[] temp = new long[end-start+1];
        while(i<=mid && j<=end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++; k++;
            }
            else{
                temp[k] = arr[j];
                k++;j++;
                count += (mid-i+1);
            }
        }
        while(i<=mid){
            temp[k] = arr[i];
            i++; k++;
        }
        while(j<=end){
            temp[k] = arr[j];
            k++;j++;
        }
        k=0;
        for(i=start ; i<=end ; i++){
            arr[i] = temp[k++];
        }
        return count;
    }
    static long mergeSort(long arr[], int start, int end){
        if(start >= end)
            return 0;
        int mid = start+(end-start)/2;
        long left = mergeSort(arr, start, mid);
        long right = mergeSort(arr, mid+1, end);
        return left + right + merge(arr, start, mid, end);
    }
    static long inversionCount(long arr[], long N)
    {
        // Method 1: brute force time limit exceeded
        // if(N == 1)
        //     return 0;
        // long count = 0;
        // for(int i=0 ; i<N-1 ; i++){
        //     for(int j=i+1 ; j<N ; j++){
        //         if(arr[i] > arr[j]){
        //             // long temp = arr[i];
        //             // arr[i] = arr[j];
        //             // arr[j] = temp;
        //             count++;
        //         }
        //     }
        // }
        // return count;
        
        //Method 2: using mergesort
        return mergeSort(arr, 0, arr.length-1);
        
    }
}
