class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        //sort the array, return k largest elements
        // int[] ans = new int[k];
        // Arrays.sort(arr);
        // int j=0;
        // for(int i=n-1 ; i>=n-k ; i--)
        //     ans[j++] = arr[i];
        // return ans;
        
        //using maxheap 
        // PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0 ; i<n ; i++)
        //     heap.add(arr[i]);
        // int[] ans = new int[k];
        // for(int i=0 ; i<k ; i++)
        //     ans[i] = heap.remove();
            
        // return ans;
        
        //using minheap, store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i=0;
        for(; i<k ; i++){
            minHeap.add(arr[i]);
        }
        for( i=k ; i<n ; i++){
            if(minHeap.peek() < arr[i]){
                minHeap.remove();
                minHeap.add(arr[i]);
            }
        }
        int[] ans = new int[k];
        i=k;
        while(!minHeap.isEmpty()){
            ans[--k] = minHeap.remove();
        }
        return ans;
    }
}
