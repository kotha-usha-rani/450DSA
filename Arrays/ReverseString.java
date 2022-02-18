class ReverseString
{
    public static void main(String[] args){
        String str = "Hello Usha!";
        System.out.println(str.reverseWord(str));
    }
    //********Method 3 recursion with extra space********
    // public static String reverse(String str, int index){
    //     if(index >= str.length())
    //         return "";
    //     return reverse(str, index+1) + str.charAt(index);
    // }

    public static String reverseWord(String str)
    {
        //********Method 1 store the ans in a new string object********
        // String ans = "";
        // for(int i=str.length()-1 ; i>=0 ; i--){
        //     ans += str.charAt(i);
        // }
        // return ans;
        

        //********Method 2 using inbuilt reverse function********
        // StringBuffer sb = new StringBuffer(str);
        // sb.reverse();
        // return sb.toString();
        

        //above three lines of code can be replaced with 
        //return new StringBuffer(str).reverse.toString();
        

        //********Method 3 recursion********
        //return reverse(str, 0);
        

        //********Method 4 store the character os the string in a byte array********
        char[] arr = str.toCharArray();
        StringBuilder ans = new StringBuilder();
        for(int i=str.length()-1 ; i>=0 ; i--){
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}