import java.util.*;
public class KthLargest{

	public static void main(String[] args){
		int[] arr = { 4,3,1,6,8,9};
		System.out.println(findKthLargest(arr, 0, arr.length-1, 3));
		System.out.println(findKthLargestUsingPQ(arr, 0, arr.length-1, 3));
	}
	public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int start, int end){
        int t = (int)(Math.random()*(end-start+1))+start;
        swap(arr, t, end);
        int pivot = arr[end];
        int j=start;
        for(int i=start ; i<end ;){
            if(arr[i] >= pivot){
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        swap(arr, j, end);
        return j;
    }

	public static int findKthLargest(int[] arr, int l, int r, int k){
		//Method 1 sorting the array, arr[n-k] will be the kth largest
		// if(k >= arr.length){
		// 	return -1;
		// }
		// Arrays.sort(arr);
		// return arr[arr.length-k];


        // Method 2 Using Quick Select->partition, if index is == k-1, return the element
        if(l<=r && k-1>=l && k-1<=r){
            int pivot = partition(arr, l, r);
            if(pivot == k-1)
                return arr[pivot];
            if(pivot < k-1)
                return findKthLargest(arr, pivot+1, r, k);
            else
                return findKthLargest(arr, l, pivot-1, k);
        }
        return 0;
	}

	//Method 3 Using a priority queue, priority is the value
	public static int findKthLargestUsingPQ(int[] arr, int l, int r, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
        	public int compare(Integer a, Integer b){
        		if(a<b)
        			return 1 ;
        		if(a>b)
        			return -1;
        		return 0;
        	}
        });
        for(int i=0 ; i<=r ; i++){
            queue.add(arr[i]);
        }
        int i=k;
        while(i>1){
            queue.poll();
            i--;
        }
        return queue.peek();
    }
}
