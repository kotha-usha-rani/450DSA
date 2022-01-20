class kthSmallest{

    public static void main(String[] args){
        int[] arr = {2, 1, 9, 4, 8, 3, 5};
        System.out.println(kthSmallest(arr, 0, arr.length-1, 3));
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
            if(arr[i] <= pivot){
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        swap(arr, j, end);
        return j;
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        
        //Method 1 sort the array, return arr[k-1] th element
        // Arrays.sort(arr);
        // return arr[k-1];
        

        //Method 2 Using a priority queue, priority is the value
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        // for(int i=0 ; i<=r ; i++){
        //     queue.add(arr[i]);
        // }
        // int i=k;
        // while(i>1){
        //     queue.poll();
        //     i--;
        // }
        // return queue.peek();
        

        //Method 3 Using Quick Select->partition, if index is == k-1, return the element
        if(l<=r && k-1>=l && k-1<=r){
            int pivot = partition(arr, l, r);
            if(pivot == k-1)
                return arr[pivot];
            if(pivot < k-1)
                return kthSmallest(arr, pivot+1, r, k);
            else
                return kthSmallest(arr, l, pivot-1, k);
        }
        return 0;
    } 
}
