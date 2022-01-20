class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
    //Method 1 sort both the arrays, count the unique elements
    //   Arrays.sort(a);
    //     Arrays.sort(b);
    //     int i=0;
    //     int j=0;
    //     int count = 0;
    //     int prev = -1;
    //     while(i<n && j<m){
    //         if(a[i] == b[j]){
    //             if(a[i] != prev){
    //                 prev = a[i];
    //                 count++;
    //             }
    //             i++;j++;
    //         }
    //         else if(a[i] < b[j]){
    //             if(a[i] != prev){
    //                 prev = a[i];
    //                 count++;
    //             }
    //             i++;
    //         }
    //         else {
    //             if(b[j] != prev){
    //                 prev = b[j];
    //                 count++;
    //             }
    //              j++;
    //         }
    //     }
    //     while(i<n){
    //         if(a[i] != prev){
    //             count++;
    //             prev = a[i];
    //         }
    //         i++;
    //     }
    //     while(j<m){
    //         if(b[j] != prev){
    //             count++;
    //             prev = b[j];
    //         }
    //         j++;
    //     }
    //     return count;
    

    //Method 2 HashSet->store only unique values, return the size of HashSet
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0 ; i<n ; i++)
        //     set.add(a[i]);
        // for(int i=0 ; i<m ; i++)
        //     set.add(b[i]);
        // return set.size();


    //Method 3 HashMap-> has unique keys
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++)
            map.put(a[i], i);
        for(int i=0 ; i<m ; i++)
            map.put(b[i], i);
        return map.size();
            
    }

    //Method 4
    //Return an arraylist of union of arrays, here elements are distinct
    //array elements are distinct
    //sort the smallest array and store the unique elements from both the arrays
    public static boolean binarySearch(int[] arr, int start, int end, int ele){
        if(start > end)
            return false;
        int mid = start + (end-start)/2;
        if(arr[mid] == ele)
            return true;
        if(ele < arr[mid])
            return binarySearch(arr, start, mid-1, ele);
        else
            return binarySearch(arr, mid+1, end, ele);

    }
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<arr1.length ; i++)
            ans.add(arr1[i]);

        for(int i=0 ; i<arr2.length ; i++){
            if(!binarySearch(arr1, 0, arr1.length-1, arr2[i])){
                ans.add(arr2[i]);
            }
        }
        return ans;

    }
    public static ArrayList<Integer> union(int[] arr1, int[] arr2){
        
        if(arr1.length <= arr2.length)
            return findUnion(arr1, arr2);
        else
            return findUnion(arr2, arr1);
    }
}
