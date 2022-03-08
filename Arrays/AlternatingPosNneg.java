import java.util.Arrays;
class AlternatingPosNneg{
	public static void main(String[] args){
		int[] arr = {1, 2, 3, -4, -1, 4};
		solution(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void solution(int[] arr){
		int i=0, j=1;
		while(true){
			while(i<arr.length && arr[i] < 0){
				i+=2;
			}
			while(j<arr.length && arr[j] > 0){
				j+=2;
			}
			if(i<arr.length && j<arr.length){
				swap(arr, i, j);
				i+=2;j+=2;
			}
			else
				break;
		}
		int k=arr.length-1;
		while(i<k){                                       
			if(arr[k] < 0){
				swap(arr, i, k);
				i+=2;
			}
			k--;
		}
		while(j<k){
			if(arr[k] > 0){
				swap(arr, j, k);
				j+=2;
			}
			k--;
		}
	}
}