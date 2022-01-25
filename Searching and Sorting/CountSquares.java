class CountSquares{
    static int binarySearch(int N){
        long start = 1;
        long end = N/2;
        int ans = 0 ;
        while(start <= end){
            long mid = start + (end-start)/2;
            if(mid*mid == N-1)
                return (int)mid ;
            if(mid*mid < N-1){
                ans = (int)mid ;
                start = mid+1;
            }
            else{
                end = mid-1 ;
            }
        }
        return ans ;
    }
    static int countSquares(int N) {
        if(N==1)
            return 0 ;
        
        //Method 1 check for each number less than queare root of N
        // double end = Math.sqrt(N);
        // int count = 0;
        // for(int i=1 ; i<end ; i++){
        //     if(i*i < N)
        //         count++;
        // }
        // return count;
        
        
        //Method 2 number of perfect squares = sqrt(n-1)
        // return (int)Math.sqrt(N-1);
        
        //Method 3 using binary search
        return binarySearch(N);
    }
}