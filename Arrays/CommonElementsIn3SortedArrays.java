class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        //Method 1: find common from A and B, then find common from ans and C
        // int i=0, j=0;
        // ArrayList<Integer> ans = new ArrayList<>();
        // while(i<n1 && j<n2){
        //     if(A[i] == B[j]){
        //         ans.add(A[i]);
        //         i++;j++;
        //     }
        //     else if(A[i] < B[j])
        //         i++;
        //     else
        //         j++;
        // }
        // i=0;j=0;
        // while(i<n3 && j<ans.size()){
        //     if(C[i] == ans.get(j)){
        //         i++;j++;
        //     }
        //     else if(C[i] < ans.get(j))
        //         i++;
        //     else{
        //         ans.remove(j);
        //     }
        // }
        // while(j< ans.size()){
        //     ans.remove(j);
        // }
        // if(ans.size()!=0){
        //     int prev = ans.get(0);
        //     for(i=1 ; i<ans.size() ;){
        //         if(ans.get(i) == prev)
        //             ans.remove(i);
        //         else{
        //             prev = ans.get(i);
        //             i++;
        //         }
        //     }
        // }
        // return ans;  
        
        
        //Method 2 using 3 pointers for 3 arrays
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0, j=0, k=0;
        while(i<n1 && j<n2 && k<n3){
            if(A[i] == B[j] && B[j] == C[k]){
                ans.add(A[i]);
                i++;j++;k++;
            }
            else if(A[i] <= B[j] && A[i] <= C[k])
                i++;
            else if(B[j] <= A[i] && B[j] <= C[k])
                j++;
            else
                k++;
        }
        if(ans.size() > 0){
            int prev = ans.get(0);
            for(i=1 ; i<ans.size() ; ){
                if(ans.get(i) == prev)
                    ans.remove(i);
                else{
                    prev = ans.get(i);
                    i++;
                }
            }
        }
        return ans;
    }
}
