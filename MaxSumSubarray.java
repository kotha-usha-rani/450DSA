public class MaxSumSubarray{
	public static void main(String[] args){
		int[] arr = {-1,-2,-3,-4};
		System.out.println(sum(arr));
	}

	//Method 1 recursive
	public static long findSum(int[] arr, int start){
		if(start >= arr.length){
			return 0l;
		}
		return arr[start] + findSum(arr, start+1);
	}
	public static long sum(int[] arr){
		long max = arr[0] ;
		for(int i=0 ; i<arr.length ; i++){
			max = (long)Math.max(findSum(arr, i), max);
		}
		return max;
	}


	// Method 2 Using Kadane's algorithm
	int sum = 0;
    int max = Integer.MIN_VALUE;
    for(int i=0 ; i<n ; i++){
        sum += arr[i];
        if(sum > max)
            max = sum ;
        if(sum < 0)
            sum = 0 ;
    }
    return max;


    //Method 3 
    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long findSum(int[] arr, int start){
	    long sum = 0;
	    long max = arr[start];
	    for(int i=start ; i<arr.length ; i++){
	        sum += arr[i];
	        max = (long)Math.max(sum, max);
	    }
	    return max;
	}
    long maxSubarraySum(int arr[], int n){
        
        long max = arr[0] ;
		for(int i=0 ; i<arr.length ; i++){
			max = (long)Math.max(findSum(arr, i), max);
		}
		return max;
        
    }
}