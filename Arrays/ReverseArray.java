import java.util.*;
class ReverseArray{
	public static void main(String[] args){
		int[] arr1 = {1, 2, 3, 4, 5};
		reverseFunction(arr1);
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = {5, 6, 7, 8, 9};
		reverseUsingRecursion(arr2, 0);
		System.out.println(Arrays.toString(arr2));
		int[] arr3 = {12, 13, 14, 15, 16};
		reverseRescursionTwoPointers(arr3, 0, arr3.length-1);
		System.out.println(Arrays.toString(arr3));
	}
	//using 2 pointers-->bruteforce
	public static void reverseFunction(int[] arr){
		int i=0;//start pointer
		int j=arr.length-1;//end pointer
		while(i<=arr.length/2 && j>=arr.length/2){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	//using recursion
	public static void reverseUsingRecursion(int[] arr, int i){
		if(i > arr.length/2){
			return;
		}
		reverseUsingRecursion(arr, i+1);
		int temp = arr[i] ;
		arr[i] = arr[arr.length-i-1];
		arr[arr.length-i-1] = temp;
	}
	//using recursion just like two pointers
	public static void reverseRescursionTwoPointers(int[] arr, int start, int end){
		if(start > end)
			return;
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp ;
		reverseRescursionTwoPointers(arr, start+1, end-1);
	}
}
