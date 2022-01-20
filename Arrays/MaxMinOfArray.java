import java.util.Scanner;
import java.util.Arrays;
public class MaxMinOfArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the elmenets of the array: ");
		for(int i=0 ; i<size ;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Method 1");
		TwoVar ans = new TwoVar();
		ans = findMinMax(arr);
		System.out.println("Minimum: "+ans.min+" "+"Maximum: "+ans.max);
		
		System.out.println("Method 2");
		TwoVar ans1 = new TwoVar();
		ans1 = findMinMaxDivide(arr, 0, size-1);
		System.out.println("Minimum: "+ans1.min+" "+"Maximum: "+ans1.max);

		System.out.println("Method 3");
		TwoVar ans2 = new TwoVar();
		ans2 = findMinMaxInPairs(arr);
		System.out.println("Minimum: "+ans2.min+" "+"Maximum: "+ans2.max);
	}
	//using objects to return multiples values(min, max)
	public static TwoVar findMinMax(int[] arr){
		int min = arr[0];
		int max = arr[0];
		for(int i=1 ; i<arr.length ; i++){
			if(arr[i] < min)
				min = arr[i];
			else if(arr[i] > max)
				max = arr[i];
		}
		TwoVar ans = new TwoVar();
		ans.min = min;
		ans.max = max;
		return ans;
	}
	//dividing the array to get min and max of the two and compare the min and max of the two halves to get the min and max of the given array
	public static TwoVar findMinMaxDivide(int[] arr, int start, int end){
		TwoVar ans = new TwoVar();
		if(start == end){
			ans.min = arr[start];
			ans.max = arr[start];
			return ans;
		}
		if(start+1 == end){
			if(arr[start] < arr[end]){
				ans.min = arr[start];
				ans.max = arr[end];
			}
			else{
				ans.max = arr[start];
				ans.min = arr[end];
			}
		}
		int mid = start + (end-start)/2;
		TwoVar left = findMinMaxDivide(arr, start, mid);
		TwoVar right = findMinMaxDivide(arr, mid+1, end);
		if(left.min < right.min)
			ans.min = left.min;
		else
			ans.min = right.min;
		if(left.max > right.max)
			ans.max = left.max;
		else
			ans.max = right.max;
		return ans ;
	}
	//compare using pairs
	public static TwoVar findMinMaxInPairs(int[] arr){
		TwoVar ans = new TwoVar();
		if(arr.length%2 != 0){
			ans.min = arr[0];
			ans.max = arr[0];
		}
		else { 
			if(arr[0] < arr[1]){
				ans.min = arr[0];
				ans.max = arr[1];
			}
			else{
				ans.min = arr[1];
				ans.max = arr[0];
			}
		}
		int i=2 ;
		while(i<arr.length-1){
			if(arr[i] < arr[i+1]){
				if(arr[i] < ans.min)
					ans.min = arr[i];
				if(arr[i+1] > ans.max)
					ans.max = arr[i+1];
			}
			else{
				if(arr[i] > ans.max)
					ans.max = arr[i];
				if(arr[i+1] < ans.min)
					ans.min = arr[i+1];
			}
			i+=2;
		}
		return ans ;
	}
}
class TwoVar{
	int min;
	int max;
}
