public class SinglyLinkedList{

	private Node head;

	private static class Node{
		private int data;
		private Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public void display(){
		//Traversing
		Node a = head;

		while(a != null){
			System.out.print("| "+a.data+" | -->");
			a = a.next;
		}

		System.out.println("null");
	}

	public int length(){
		Node current = head;
		int length = 0;
		while(current != null){
			length++;
			current = current.next;
		}
		return length;
	}

	public void insertBeginning(Node a){
		a.next = head;
		head = a;
	}

	public void insertEnd(Node a){
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = a;
	}

	public boolean isItem(int d){
		Node current = head;
		while(current != null){
			if(current.data == d)
				return true;
			current = current.next;
		}
		return false;
	}

	public void reverse(){
		if(this.head == null)
			return;
		Node current = head;
		Node next = null;
		Node prev = null;
		while(current != null){
			next = current.next;
			//Here head will point to null, and then will point to the prev (later next) node.
			current.next = prev;
			prev = current;
			current = next;
		}
		this.head = prev;
	}

	public Node middle(){
		Node fastPtr = head;
		Node slowPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	public Node selectFromEnd(int n){
		Node refptr = head;
		Node mainptr = head;
		int cont = 0;
		while(cont<n){
			refptr = refptr.next;
			cont++;
		}
		while(refptr != null){
			refptr = refptr.next;
			mainptr = mainptr.next;
		}
		return mainptr;
	}

	public void removeDuplicates(){
		Node current = head;
		while(current!=null && current.next!=null){
			if(current.data == current.next.data){
				current.next = current.next.next;
			}
			else{
				current = current.next;
			}
		}
	}

	public void addNodeSorted(Node newNode){
		Node temp = null;
		Node current = head;
		while(current!= null && current.data<newNode.data){
			temp = current;
			current = current.next;
		}
		temp.next = newNode;
		newNode.next = current;
	}

	public void removeNode(Node nodeToRemove){
		Node temp = null;
		Node current = head;
		while(current != null && current.data!=nodeToRemove.data){
			temp = current;
			current = current.next;
		}
		//Exits loop when current null or current is the element
		
		//If not found
		if (current == null)
			return;
		//Else, the previous of current will point to the next of current.
		temp.next = current.next;

	}

	public boolean hasLoop(){
		Node slowptr = head;
		Node fastptr = head;
		while(fastptr != null && fastptr.next != null){
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
			if(slowptr == fastptr)
				return true;
		}
		return false;

	}

	//Main
	public static void main(String[] args){
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new Node(10);
		//Node second = new Node(9);
		//sll.head.next = second;
		sll.display();
		System.out.println(sll.length());
		sll.insertBeginning(new Node(23));
		sll.insertBeginning(new Node(234));
		sll.display();
		sll.insertEnd(new Node(899));
		sll.display();
		if (sll.isItem(10)){
			System.out.println("It is");
		}
		sll.reverse();
		sll.display();
		sll.insertEnd(new Node(192));
		sll.insertEnd(new Node(192));
		sll.display();
		SinglyLinkedList a = new SinglyLinkedList();
		a.head = new Node(5);
		a.insertEnd(new Node(9));
		a.insertEnd(new Node(16));
		System.out.println(sll.middle().data);
		System.out.println(sll.selectFromEnd(2).data);
		sll.removeDuplicates();
		sll.display();
		a.display();
		a.addNodeSorted(new Node(19));
		a.addNodeSorted(new Node(10));
		a.removeNode(new Node(16));
		a.display();
		System.out.println("finish");
	}

}
