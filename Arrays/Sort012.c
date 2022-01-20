void sort012(int arr[], int n)
{
    //Method 1 Count the numbers os 1's, 2's, 3's, replace the array with count times
    // int count0 = 0;
    // int count1 = 0;
    // int count2 = 0 ;
    // for(int i=0 ; i<n ; i++){
    //     if(arr[i] == 0)
    //         count0++;
    //     else if(arr[i] == 1)
    //         count1++;
    //     else if(arr[i] == 2)
    //         count2++;
    // }
    // int i=0;
    // for(; i<count0 ; i++){
    //     arr[i] = 0;
    // }
    // int temp = i ;
    // for(; i<count1+temp ; i++){
    //     arr[i] = 1;
    // }
    // temp = i ;
    //  for(; i<count2+temp ; i++){
    //     arr[i] = 2;
    // }

    //Method 2 Dutch National Flag Algorithm->three way partititon
    //low-mid has 0's, mid-high has 1's, high-end has 2's
    int low =0 ;
    int mid=0 ;
    int high = n-1;
    while(mid<=high){
        if(arr[mid]==0){
            int temp = arr[mid];
            arr[mid] = arr[low];
            arr[low] = temp;
            mid++;
            low++;
        }
        else if(arr[mid] == 1){
            mid++;
        }
        else{
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp ;
            high--;
        }
    }
    
    
}
