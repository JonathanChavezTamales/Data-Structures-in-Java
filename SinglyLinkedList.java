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


	//Main
	public static void main(String[] args){
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new Node(10);
		//Node second = new Node(9);
		//sll.head.next = second;
		sll.display();
		System.out.println(sll.length());

	}

}
