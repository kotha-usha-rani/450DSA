class Solution{
  
  public void swap(int[] arr1, int[] arr2, int i, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
  
  public void merge(int arr1[], int arr2[], int n, int m) {
          ///Method1 using temp array to store the sorted elements tc = O(m+n), sc = O(m+n)
          // int[] temp = new int[n+m];
          // int i=0;
          // int j=0;
          // int k=0;
          // while(i<n && j<m){
          //     if(arr1[i] < arr2[j])
          //         temp[k++] = arr1[i++];
          //     else
          //         temp[k++] = arr2[j++];
          // }
          // while(i<n){
          //     temp[k++] = arr1[i++];
          // }
          // while(j<m){
          //     temp[k++] = arr2[j++];
          // }

          // for(i=0 ; i<n ; i++){
          //     arr1[i] = temp[i];
          // }
          // for(j=0 ; j<m ; j++){
          //     arr2[j] = temp[n+j];
          // }

          //Method 2 using insertion sort
          for(int i=0 ; i<arr1.length ; i++){
              if(arr1[i] > arr2[0]){
                  int temp = arr1[i];
                  arr1[i] = arr2[0];
                  arr2[0] = temp;
                  Arrays.sort(arr2);
              }
          }
    
    //method 3 using gap algorithm
        int i, j, gap, temp;
        Boolean isIinArr2, isJinArr1;
        gap = m+n;
        while(gap != 1){
            isJinArr1 = false;
            if(gap%2 != 0)
                gap = (int)Math.ceil(gap/2.0);
            else
                gap = gap/2;
            i=0;
            if(gap > n-1)
                j = gap-n ;
            else{
                j = gap;
                isJinArr1 = true;
            }
            isIinArr2 = false;
            if(isJinArr1){
                while(j<n){
                    if(arr1[i] > arr1[j])
                        swap(arr1, arr1, i, j);
                    i++;j++;
                }
                j=0; isJinArr1 = false;
            }  
            if(!isIinArr2){
                while(i < n && j<m){
                    if(arr1[i] > arr2[j])
                        swap(arr1, arr2, i, j);
                    i++;j++;
                }
                i=0; isIinArr2 = true;
            }
            while(j<m){
                if(arr2[i] > arr2[j])
                    swap(arr2, arr2, i, j);
                i++; j++;
            }
            
        }
  }
