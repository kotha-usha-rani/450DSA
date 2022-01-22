import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
class IntersectionOfTwoArrays{
	public static void main(String[] args){
		int[] arr1 = {4,1,9,6,2,8,1,4};
		int[] arr2 = {6,7,5,3,1,2,6,7};
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(intersection(arr1, arr2)));
	}
	public static int[] sort(int[] arr1, int[] arr2){
		Arrays.sort(arr1);
		HashSet<Integer> set = new HashSet<>();
		for(int i=0 ; i<arr2.length ; i++){
			int index = Arrays.binarySearch(arr1, arr2[i]);
			if(index >=0 && index <arr1.length)
				set.add(arr2[i]);
		}
		int[] ans = new int[set.size()];
		int k=0;
		for(int ele : set){
			ans[k++] = ele;
		}
		return ans;

	}
	public static int[] intersection(int[] arr1, int[] arr2){
		//Method 1 Using loops O(m*n)
		// HashSet<Integer> set = new HashSet<>();
		// for(int i=0 ; i<arr1.length ; i++){
		// 	for(int j=0 ; j<arr2.length ; j++){
		// 		if(arr1[i] == arr2[j])
		// 			set.add(arr1[i]);
		// 	}
		// }
		// int[] ans = new int[set.size()];
		// int k=0;
		// for(int i : set){
		// 	ans[k++] = i;
		// }
		// return ans;


		//Method 2 sort both the arrays, using two pointers O(mlogm)+O(nlogn)+O(m+n) => O(mlogn + nlogn)
		// Arrays.sort(arr1);
		// Arrays.sort(arr2);
		// int i=0 ; int j= 0;
		// ArrayList<Integer> arr = new ArrayList<>();
		// while(i<arr1.length && j<arr2.length){
		// 	if(arr1[i] == arr2[j]){
		// 		arr.add(arr1[i]);
		// 		i++;j++;
		// 	}
		// 	else if(arr1[i] < arr2[j]){
		// 		i++;
		// 	}
		// 	else{
		// 		j++;
		// 	}
		// }
		// int[] ans = new int[arr.size()];
		// int k=0;
		// for(int ele : arr){
		// 	ans[k++] = ele ;
		// }
		// return ans ;

		//Method 3 sort on of the(smallest preferred) array, do binay search on another array
		// if(arr1.length < arr2.length)
		// 	return sort(arr1, arr2);
		// else
		// 	return sort(arr2, arr1);

		//Method 4 using hashmap
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0 ; i<arr1.length ; i++){
			map.put(arr1[i], i);
		}
		HashSet<Integer> arr = new HashSet<>();
		for(int i=0 ; i<arr2.length ; i++){
			if(map.containsKey(arr2[i]))
				arr.add(arr2[i]);
		}
		int[] ans = new int[arr.size()];
		int k=0;
		for(int ele : arr)
			ans[k++] = ele;
		return ans;
	}
}