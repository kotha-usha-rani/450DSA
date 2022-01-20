class Solution {
        //Method 2 binary search on each row
        public boolean binarySearch(int[][] matrix, int row, int target){
            int start=0;
            int end = matrix[row].length-1;
            while(start <= end){
                int mid = start +(end-start)/2;
                if(matrix[row][mid] == target)
                    return true;
                if(target < matrix[row][mid])
                    end = mid-1;
                else
                    start = mid+1;  
            }
            return false;
            
        }
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Method 1 linear search
        
        // for(int i=0 ; i<matrix.length ; i++){
        //     for(int j=0 ; j<matrix[i].length ; j++){
        //         if(matrix[i][j] == target)
        //             return true;
        //     }
        // }
        // return false;
        
        //Method 2 binary search on each row
        
        // for(int i=0 ; i<matrix.length ; i++){
        //     if(target >= matrix[i][0] && binarySearch(matrix, i, target))
        //         return true;
        // }
        // return false;
        
        //Method 3 Eliminate col and rows
        
        // int col = matrix[0].length-1;
        // int row =0;
        // while(col >= 0 && row < matrix.length){
        //     if(target == matrix[row][col])
        //         return true;
        //     if(target < matrix[row][col])
        //         col--;
        //     else
        //         row++;
        // }
        // return false;
        
        //Method 4 the array is sorted->use binary search
        
        int start = 0;
        int end = matrix.length*matrix[0].length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length] == target)
                return true;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }
}