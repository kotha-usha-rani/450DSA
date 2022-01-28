class Add1toNumberInList{
	public static int solution(Node head){
        if(head == null){
            return 1;
        }
        int rem = solution(head.next);
        int data = head.data+rem;
        head.data = data%10;
        return data%10;
    }
    
    public static Node addOne(Node head) 
    { 
        if(head == null)
            return null;
        if(head.next == null){
            head.data = head.data+1;
            return head;
        }
        //Method 1 recursive
        //   int temp = head.data;
        //   int ans = solution(head);
        //   if(ans != 0)
        //     head.data = temp+ans;
        //   return head;
    
        //Method 2 using arraylist to store data
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.data);
            temp = temp.next ;
        }
        int rem = 1;
        for(int i=arr.size()-1 ; i>=0 ; i--){
            int data = arr.get(i)+rem;
            arr.set(i, data%10);
            if(data != 10)
                rem=0;
        }
        if(rem == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        if(rem == 1)
            temp = head.next;
        else
            temp = head;
        int i=0;
        while(temp != null){
            temp.data = arr.get(i);
            temp = temp.next;
            i++;
        }
        return head;
        
        //Method 3 reverse the list, modify the elements and reverse again
        
    }
}