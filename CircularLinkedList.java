public class CircularLinkedList{
	
	Node last;
	int length;


	public static class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
		}
	}


	public void addToBeginning(Node newNode){
		if(length == 0){
			last = newNode;
		}
		else{
			newNode.next = last.next;
		}
		last.next = newNode;
		length++;
	}

	public void addToEnd(Node newNode){
		if(length == 0){
			last = newNode;
			last.next = newNode;
		}
		else{
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
		length++;
	}

	public void traverse(){
		Node first = last.next;
		while(first != last){
			System.out.println(first.data);
			first = first.next;
		}
		System.out.println(last.data);
	}

	public void removeFirst(){
		//You should catch an exception when no elements
		Node first = last.next;
		last.next = first.next;
		first.next = null;
	}

	public static void main(String[] args){
		CircularLinkedList cll = new CircularLinkedList();
		cll.addToBeginning(new Node(5));
		cll.addToBeginning(new Node(8));
		cll.addToEnd(new Node(9));
		cll.traverse();
		cll.removeFirst();
		cll.traverse();
	}

}
