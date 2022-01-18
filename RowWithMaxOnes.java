class RowWithMaxOnes {
	public static void main(String[] args){
		int[][] arr = {
			{0, 1, 1, 1},
			{0, 0, 1, 1},
			{1, 1, 1, 1},
			{0, 0, 0, 0}
		};
		System.out.println(rowWithMax1s(arr, 4, 4));
	}
    //Method 2 Binary search
    static int binarySearch(int[] arr, int start, int end){
        if(start > end)
            return -1 ;
        int mid = start + (end-start)/2 ;
        
        if(arr[mid] == 1){
            if((mid > 0 && arr[mid-1] != 1) || mid == 0)
                return mid;
        }
        if(arr[mid] < 1)
            return binarySearch(arr, mid+1, end);
        else
            return binarySearch(arr, start, mid-1);
        
    }
    static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        //Method 1 ->Naive -> count the number of 1's in each row and return the row with max 1's
	    
	   // int max = 0 ;
	   // int index = -1 ;
	   // for(int i=0 ; i<n ; i++){
	   //     if(arr[i][m-1] != 0){
    // 	        for(int j=0 ; j<m ; j++){
    // 	            if(arr[i][j] == 1){
    // 	                if((m-j) > max){
    // 	                    max = m-j;
    // 	                    index = i ;
    // 	                    break;
    // 	                }
    // 	            }
    // 	        }
	   //     }
	   // }
	   // return index;
	   
	   //Method 2 use binarysearch to get the index of first occurrence of 1
	   //int max = -1 ;
	   //int count = 0 ;
	   //int current = m;
	   //for(int i=0 ; i<n ; i++){
	   //    if(current == -1)
	   //     current = m-count;
	   //    current = binarySearch(arr[i], 0, current-1);
	   //    if(current > -1 && m-current > count){
	   //     max = i;
	   //     count = m-current;
	   //    }
	   //}
	   //return max ;
	   
	   //Method 3 use a for loop to traverse the rows, check from the last element until you reach 1
	   // Only check the further rows for 1's and towards left
	   int j=m-1, max = -1;
	   for(int i=0 ; i<n ; i++){
	       while(j > -1 && arr[i][j] == 1){
	           j--;
	           max = i ;
	       }
	   }
	   return max;
	   
    }
}
