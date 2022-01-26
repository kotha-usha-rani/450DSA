class MajorityElement{
	public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(majority(arr, 3));
    }
    public static int majority(int[] nums, int size){
	
        //Method 1 O(n^2) using two loops to get the count of every element----> time limit exceeded
        // int max = 0;
        // int ele = 0;
        // for(int i=0 ; i<nums.length ; i++){
        //     int count = 0;
        //     for(int j=0 ; j<nums.length ; j++){
        //         if(nums[j] == nums[i])
        //             count++;
        //     }
        //     if(count > max){
        //         max = count;
        //         ele = nums[i] ;
        //     }
        // }
        // if(max > size/2)
        //     return ele;
        // return -1 ;
        
        
        //Method 2 Moore's Voting Algorithm sort the array, find the max count of each element, return the ele with max count
        Arrays.sort(nums);
        int count = 1;
        int max = 0;
        int ele = 0 ;
        int prev = nums[0];
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i] == prev)
                count++;
            else{
                if(count > max){
                    max = count;
                    ele = prev ;
                }
                prev = nums[i];
                count = 1 ;
            }
        }
        if(count > max && count > size/2)
            return prev;
        if(max > size/2)
            return ele ;
        return -1;   
        
        //Method 3 HashMap to store the count of elements
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0 ; i<nums.length ; i++){
        //     if(map.containsKey(nums[i])){
        //       map.put(nums[i], map.get(nums[i])+1);
        //       if(map.get(nums[i]) > size/2)
        //         return nums[i];
        //     }
        //     else
        //       map.put(nums[i], 1);
        // }
        // for(Integer ele : map.keySet()){
        //     if(map.get(ele) > size/2)
        //         return ele;
        // }
        // return -1;
    }
}