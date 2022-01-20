import java.util.LinkedList;
import java.util.Queue;
class StringsAreRotations{
	public static void main(String[] args){
		String str1 = "ABCD";
		String str2 = "CDAB";
		System.out.println(RotationsOfEachOther(str1, str2));
	}
	public static boolean RotationsOfEachOther(String str1, String str2){
		

		//Method 1 find if str2 is the substring of str1+str1
		// if(str1.length() != str2.length())
		// 	return false;
		// StringBuilder sb = new StringBuilder(str1);
		// sb.append(str1);
		// if(sb.toString().indexOf(str2) != -1)
		// 	return true;
		// return false;

		//Method 2 Using queue
		if(str1.length() != str2.length())
			return false;
		Queue<Character> q1 = new LinkedList<>();
		Queue<Character> q2 = new LinkedList<>();
		for(int i=0 ; i<str1.length() ; i++){
			q1.add(str1.charAt(i));
		}
		for(int i=0 ; i<str2.length() ; i++){
			q2.add(str2.charAt(i));
		}
		int i=0;
		while(i<str1.length()){
			char ch = q2.peek();
			q2.remove(ch);
			q2.add(ch);
			if(q1.equals(q2))
				return true;
		}
		return false;
	}
}