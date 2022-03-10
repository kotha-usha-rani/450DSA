import java.util.ArrayList;
import java.util.Arrays;
class SortRowColumWiseSortedMatrix{
	public static void main(String[] args){
		int[][] mat = {
			{3, 23, 59, 70, 71},
			{4, 12, 57, 94, 99},
			{13, 22, 30, 74, 95},
			{16, 25, 38, 85, 99},
			{1, 5, 9, 19, 59}
		};
		int[] a = merge(mat, 0, mat.length-1);
		int k=0;
        for(int i=0 ; i<mat.length ; i++){
        	for(int j=0 ; j<mat.length ; j++){
        		mat[i][j] = a[k++];
        	}
        }
        
		for(int[] arr : mat){
			System.out.println(Arrays.toString(arr));
		}
	}
	public static int[] mergeSort(int[] arr1, int[] arr2){ 
        int[] arr = new int[arr1.length * 2];
        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                arr[k++] = arr1[i];
                i++;
            }
            else{
                arr[k++] = arr2[j];
                j++;
            }
        }
        while(i<arr1.length){
            arr[k++] = arr1[i];
            i++;
        }
        while(j<arr2.length){
            arr[k++] = arr2[j];
            j++;
        }
        return arr;        
    }
    
    public static int[] merge(int[][] matrix, int start, int end){
        if(start+1 == end){
            return mergeSort(matrix[start], matrix[end]);
        }
        if(start == end){
            return matrix[start];
        }
        int mid = start + (end-start)/2 ;
        int[] firstHalf = merge(matrix, start, mid);
        int[] secondHalf = merge(matrix, mid+1, end);
        return mergeSort(firstHalf, secondHalf);
        
    }
}
