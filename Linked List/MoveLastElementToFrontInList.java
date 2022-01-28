class MoveLastElementToFrontInList{
	public Node solution(Node head){
		if(head == null || head.next == null)
			return head;
		Node temp = head;
		Node last = null;
		while(temp.next.next != null){
			temp = temp.next ;
		}
		last = temp.next;
		temp.next = head;
		last.next = head.next ;
		head.next = null;
		head = last;
		return head;
	}
}