import java.util.Arrays;
public class MoveNegativesToLeft{
	public static void main(String[] args){
		int[] arr={1, -2, 2, 3, -1, 4, -1, -2, -3, -4};
		System.out.println(Arrays.toString(arr));
		moveFunction(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void moveFunction(int[] arr){
		//Method 1 two pointer approach
		int low = 0 ;
		int high = arr.length-1;
		while(low < high){
			while(low < arr.length && arr[low] < 0){
				low++;
			}
			while(high > -1 && arr[high] > 0){
				high--;
			}
			if(low < high){
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp ;
			}
		}

		//Method 2 using patititon process
		int i=0;
		int j=0;
		while(i<arr.length){
			if(arr[i] < 0){
				if(i!=j){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					j++;
				}
			}
			i++;
		}
	}
}
