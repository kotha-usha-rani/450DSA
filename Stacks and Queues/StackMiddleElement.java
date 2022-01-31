class StackMiddleElement{
	public static void main(String[] args){
		Stack st = new Stack();
		st.addElement(10);
		st.addElement(20);
		st.addElement(30);
		st.addElement(40);
		st.addElement(50);

		st.printStack();

		System.out.println(st.popElement());
		st.printStack();

		System.out.println(st.findMiddle());

		st.deleteMiddle();

		st.printStack();
	}
}

class DLL{
	int data;
	DLL next;
	DLL prev;
	DLL(int data){
		this.data = data;
		next = null;
		prev = null;
	}
}
class Stack{
	DLL top;
	DLL mid;
	DLL start;
	int size;
	Stack(){
		top = null;
		mid = null;
		start = null;
		size = 0;
	}
	public void addElement(int value){
		if(top == null){
			DLL data = new DLL(value);
			top = data;
			mid = data;
			start = data;
			size++;
		}
		else{
			DLL data = new DLL(value);
			data.prev = top;
			top.next = data;
			top = data;
			size++;
			if(size%2==0)
				mid = mid.next;
		}
	}
	public int popElement(){
		if(top == null){
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		int ele = top.data;
		top = top.prev;
		top.next = null;
		size--;
		if(size%2 != 0)
			mid = mid.prev;
		if(size <= 2)
			mid.next = null;
		return ele;
	}
	public int findMiddle(){
		if(mid == null){
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		return mid.data;
	}

	public void deleteMiddle(){
		if(mid == null){
			System.out.println("Stack is empty");
			return ;
		}
		if(top == mid){
			top = top.prev;
			mid = mid.prev;
			size--;
			if(top == null)
				start = null;
		}
		else{
			mid.prev.next = mid.next;
			mid.next.prev = mid.prev.next;
			if(size%2 == 0)
				mid = mid.prev;
			else
				mid = mid.next;
			size--;
		}
	}
	public void printStack(){
		if(top == null){
			System.out.println("Stack is empty");
			return;
		}
		DLL temp = start;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}