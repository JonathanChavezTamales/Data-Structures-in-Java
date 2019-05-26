public class Queue{
	
	Node front, rear;
	int length;

	public class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}

		public Node(){
			this.data = 0;
			this.next = null;
		}
	}

	public Queue(){
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	public boolean isEmpty(){
		return length == 0;
	}

	/*
	 * Esto podria funcionar, pero el dequeue seria muy tardado
	public void enqueue(int data){
		if(this.isEmpty())
			front = temp;
		temp.next = rear;
		rear = temp;
		length++;
	}

	*/

	public void enqueue(int data){
		Node temp = new Node(data);
		if(this.isEmpty()){
			this.front = temp;
		}
		else{
			this.rear.next = temp;
		}
		this.rear = temp;
		length++;
	}

	public int dequeue(){
		if(this.isEmpty())
			throw new RuntimeException("No hay elementos en cola");
		int removed = front.data;
		front = front.next;
		//When there is only 1 element
		if(front == null)
			rear = null;
		length--;
		return removed;
	}
	
	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
