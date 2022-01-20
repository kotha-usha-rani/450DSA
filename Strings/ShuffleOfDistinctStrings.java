import java.util.*;
class ShuffleOfDistinctStrings{
	public static void main(String[] args){
		String first = "XY";
    	String second = "12";
    	String[] results = {"1XY2", "Y1X2", "Y21XX"};
    	boolean[] ans1 = check(first, second, results);
    	System.out.println(Arrays.toString(ans1));

    	boolean[] ans2 = checkShuffle(first, second, results);
    	System.out.println(Arrays.toString(ans2));
	}
	//Method 2 Without using functions
	public static void createArr(String s, char[] arr, int start){
		int k = start;
		for(int i=0 ; i<s.length() ; i++)
			arr[k++] = s.charAt(i);
	}
	public static boolean compare(char[] temp, char[] arr){
		for(int i=0 ; i<arr.length ; i++){
			if(temp[i] != arr[i])
				return false;
		}
		return true;
	}
	public static boolean[] check(String first, String second, String[] results){
		//Method 1 store the combination of first, second a character array
		char[] arr = new char[first.length() + second.length()];
		createArr(first, arr, 0);
		createArr(second, arr, first.length());
		Arrays.sort(arr);
		boolean[] ans = new boolean[results.length];
		int k=0;
		for(int i=0 ; i<results.length ; i++){
			if(arr.length != results[i].length())
				ans[k++] = false ;
			else{
				char[] temp = new char[results[i].length()];
				createArr(results[i], temp, 0);
				Arrays.sort(temp);
				ans[k++] = compare(temp, arr);
			}
		}
		return ans;
	}
	public static String createAndSort(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return String.valueOf(arr);
	}

	//Method 2 Using functions such as to charArray
	public static boolean[] checkShuffle(String first, String second, String[] results){
		String str = first + second ;
		String s = createAndSort(str);
		boolean[] ans = new boolean[results.length];
		for(int i=0 ; i<results.length ; i++){
			if(s.length() != results[i].length())
				ans[i] = false;
			else{
				String temp = createAndSort(results[i]);
				if(temp.equals(s))
					ans[i] = true;
				else
					ans[i] = false;
			}
		}
		return ans;
	}

}
