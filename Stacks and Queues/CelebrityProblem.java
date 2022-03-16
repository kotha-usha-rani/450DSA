class CelebrityProblem
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
       //Method 1 using two loops
        // for(int i=0 ; i<n ; i++){
        //     int j=0;
        //     if(i==0)
        //         j = 1 ;
        //     if(j<n && arr[j][i] == 1){
        //         while(j<n){
        //             if(arr[i][j] != 0)
        //                 break;
        //             j++;
        //         }
        //     }
        //     if(j==n)
        //         return i ;
        // }
        // return -1;
    
    
    //Method 2 using two arrays of size n
        // int[] count = new int[n];
        // for(int i=0 ; i<n ; i++){
        //     for(int j=0 ; j<n ; j++){
        //         if(arr[i][j] == 1 && arr[j][i] != 1){
        //             count[j]++;
        //         }
        //     }
        // }
        // for(int i=0 ; i<n ; i++){
        //     if(count[i] == n-1)
        //         return i;
        // }
        // return -1;
        
    //Method 3 using a stack
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ; i<n ; i++)
            stack.push(i);
        while(stack.size() > 1){
            int r = stack.pop();
            int c = stack.pop();
            if(arr[r][c] == 1)
                stack.push(c);
            else
                stack.push(r);
        }
        if(stack.isEmpty())
            return -1;
        int cele = stack.pop();
        for(int i=0 ; i<n ; i++){
            if(cele != i)
                if(arr[cele][i] == 1 || arr[i][cele] == 0)
                    return -1;
        }
        return cele;
    }
    
    //skipping columns
    int celebrity(int M[][], int n)
    {
    	//brute force
    	int count;
    	for(int i=0 ; i<n ; i++){
    	    count = 0;
    	    for(int j=0 ; j<n ; j++){
    	        if(i==j)
    	            continue;
    	        if(M[j][i] != 1)
    	            break;
    	        else{
    	            if(M[i][j] == 1){
    	                if(j==i+1)
    	                    i+=1;
    	                break;
    	            }
    	            else
    	                count++;
    	        }
    	    }
    	    if(count == n-1)
    	        return i;
    	}
    	return -1;
}


}
