class Solution{
    int middle(int A, int B, int C){
       if(A>B && A>C){
           return Math.max(B,C);
       }
       if(B>C && B>A){
           return Math.max(C,A);
       }
       else{
           return Math.max(A,B);
       }
    }
}