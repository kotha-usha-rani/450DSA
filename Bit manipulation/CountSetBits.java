class Solution {
    static int setBits(int N) {
        //Method 1 using & and >>
        // int n = N, count = 0;
        // while(n>0){
        //     if((n&1) == 1)
        //         count++;
        //     n >>= 1;
        // }
        // return count;
        
        //Method 2 using brain kerninghan algorithm
        int n=N, count = 0;
        while(n>0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
