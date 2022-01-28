class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
          if(head == null || head.next == null)
            return head;
            
         //Method 1 using two loops to find duplicates--->time limit exceeded
       
        //  Node temp1 = head ;
        //  Node temp2 = null ;
        //  Node prev = null ;
        //  while(temp1 != null && temp1.next != null){
        //      temp2 = temp1.next ;
        //      prev = temp1;
        //      while(temp2 != null){
        //          if(temp1.data == temp2.data){
        //              prev.next = temp2.next ;
        //              temp2 = temp2.next ;
        //          }
        //          else{
        //             prev = temp2 ;
        //             temp2 = temp2.next ;
        //          }
        //      }
        //      temp1 = temp1.next ;
        //  }
        //  return head ;
        
        //Method 2 using hashmap
        Node prev = head;
        Node temp = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(temp != null){
            if(map.containsKey(temp.data))
                prev.next = temp.next;
            else{
                map.put(temp.data, 1);
                prev = temp;
            }
            temp=temp.next ;
        }
        return head ;
    }
}
