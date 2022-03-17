// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> ans = g.reverseLevelOrder(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}


 
// } Driver Code Ends



/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // ArrayList<Node> list = new ArrayList<>();
        // int i=0;
        // list.add(node);
        // list.add(null);
        // while(i<list.size()){
        //     Node temp = list.get(i);
        //     if(temp != null){
        //         if(temp.left != null)
        //             list.add(temp.left);
        //         if(temp.right != null)
        //             list.add(temp.right);
        //     }
        //     else{
        //         if(i+1 == list.size())
        //             break;
        //         list.add(null);
        //     }
        //     i++;
        // }
        // int k=0;
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(i=0 ; i<list.size() ; i++){
        //     k=0;
        //     while(list.get(i) != null){
        //         ans.add(k,list.get(i).data);
        //         k++;i++;
        //     }
        // }
        // return ans;
        
        // ArrayList<Integer> ans = new ArrayList<>();
        // if(node == null)
        //     return ans;
        // ArrayList<Node> list = new ArrayList<>();
        // list.add(node);
        // int i=0;
        // while(i != list.size()){
        //     Node temp = list.get(i);
        //     if(temp.right != null)
        //         list.add(temp.right);
        //     if(temp.left != null)
        //         list.add(temp.left);
        //     i++;
        // }
        // for(i=0 ; i<list.size() ; i++){
        //     ans.add(0, list.get(i).data);
        // }
        // return ans;
        
        
        //Stack and queue
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            ans.add(0,temp.data);
            if(temp.right != null)
                queue.add(temp.right);
            if(temp.left != null)
                queue.add(temp.left);
        }
        return ans;
    }
}      







