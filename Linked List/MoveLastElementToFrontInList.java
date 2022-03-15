class MoveLastElementToFrontInList{
	public Node solution(Node head){
		if(head == null || head.next == null)
			return head;
		Node temp = head;
		while(temp.next.next != null){
			temp = temp.next ;
		}
		temp.next.next = head;
		head = temp.next;
		temp.next = null;
		return head;
	}
}
