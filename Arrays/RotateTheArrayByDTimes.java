import java.util.Arrays;
public class RotateTheArrayByDTimes{
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int d = 3 ;
		System.out.println(Arrays.toString(arr));
		// rotateUsigReversalAlgo(arr, d);
		// System.out.println(Arrays.toString(arr));

		// rotateUsingTempArray(arr, d);
		// System.out.println(Arrays.toString(arr));

		rotateByDTimes(arr, d, arr.length);
		System.out.println(Arrays.toString(arr));

	}
	// Method 1 Using Reversal algorithm
	public static void rotateByD(int[] arr, int start, int end){
		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public static void rotateUsigReversalAlgo(int[] arr, int d){
		if(d == 0)
			return;
		rotateByD(arr, 0, d-1);
		rotateByD(arr, d, arr.length-1);
		rotateByD(arr, 0, arr.length-1);
	}

	// Method 2 Usind temp array
	public static void rotateUsingTempArray(int[] arr, int d){
		int n = arr.length;
		int[] temp = new int[d];
		for(int i=0 ; i<d ; i++){
			temp[i] = arr[i];
		}
		int i=0;
		for(; i<n-d ; i++){
			arr[i] = arr[i+d];
		}
		int k=0;
		for(; i<n ; i++){
			arr[i] = temp[k];
			k++;
		}
	}

	// Method 3 rotate once by d times
	public static void rotate(int[] arr, int start, int end){
		int temp = arr[start];
		int i=start;
		for(; i<end-1 ; i++){
			arr[i] = arr[i+1]; 
		}
		arr[i] = temp;
	}
	public static void rotateByDTimes(int[] arr, int d, int n){
		for(int i=0 ; i<d ; i++){
			rotate(arr, 0, n);
		}
	}

	// Method 4 Using Juggling algorithm
	public static int find_gcd(int n, int d){
		if(d==0)
			return n;
		return find_gcd(d, n%d);
	}
	
}
