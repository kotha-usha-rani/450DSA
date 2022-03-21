/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

*************************************************************/
import java.util.Stack;
public class Solution
{
    public static int findCloseBracket(String str, int i, int end){
        if(i>end || i+1 == end)
            return -1;
       	Stack<Character> stack = new Stack<Character>();
        stack.push('(');
        i++;
        while(!stack.isEmpty() && i<=end){
            if(str.charAt(i) == '(')
                stack.push('(');
            else if(str.charAt(i) == ')'){
                stack.pop();
                if(stack.isEmpty())
                    return i;
            }
            i++;
        }
        return -1;
    }
    public static BinaryTreeNode<Integer> solution(String str, int start, int end){
        if(start > end)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode(str.charAt(start)-'0');
        int index = findCloseBracket(str, start+1, end);   
        if(index != -1){
            root.left = solution(str, start+2, index-1);
        	root.right = solution(str, index+2, end-1);
        }
        return root;
    }
    public static BinaryTreeNode<Integer> preorder(BinaryTreeNode<Integer> root){
        if(root == null)
            return null;
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(root.data);
        newNode.left = preorder(root.left);
        newNode.right = preorder(root.right);
        return newNode;
    }
    public static BinaryTreeNode<Integer> treeFromBracket(String str)
    {
        BinaryTreeNode<Integer> ans = solution(str, 0, str.length()-1);
        return preorder(ans);
    }
}
