class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Queue to store roots
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            ans.add(temp.data);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return ans;
    }
}
