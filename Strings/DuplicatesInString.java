import java.util.ArrayList;
import java.util.HashMap;
class DuplicatesInString{
	public static void main(String[] args){
		String s = "geeksforgeeks";
		ArrayList<Pair> ans = getDuplicateCount(s);
		for(int i=0 ; i<ans.size() ; i++){
			System.out.println(ans.get(i).ch+" "+ans.get(i).count);
		}
	}
	public static ArrayList<Pair> getDuplicateCount(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0 ; i<s.length() ; i++){
			Character c = s.charAt(i);
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
		ArrayList<Pair> ans = new ArrayList<>();
		for(Character ch : map.keySet()){
			if(map.get(ch) > 1){
				Pair temp = new Pair();
				temp.ch = ch;
				temp.count = map.get(ch);
				ans.add(temp);
			}
		}
		return ans;
	}
}
class Pair{
	char ch;
	int count;

}
