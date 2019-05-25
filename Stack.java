import java.util.EmptyStackException;

public class Stack{
	Node top;
	int length;

	private class Node{
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

	public Stack(){
		this.length = 0;
		this.top = null;
	}

	public boolean isEmpty(){
		return length == 0;
	}

	public void push(int value){
		Node temp = new Node(value);
		temp.next = this.top;
		this.top = temp;
		this.length++;
	}

	public int pop(){
		if (this.isEmpty())
			throw new EmptyStackException();
		int removed = top.data;
		top = top.next;
		length--;
		return removed;
	}

	public int peek(){
		if(this.isEmpty())
			throw new EmptyStackException();
		return top.data;
	}

	public void experimento(){
		//Ver a donde apunta el next del primer pusheado
		Node temp = top;
		System.out.println(top.data);
		while(temp.data != 1){
			temp = temp.next;
		}
		System.out.println("DATA: "+ temp.data);
		System.out.println("UNKNOWN: "+ temp.next.data);
	}
	
	public static void main(String[] args){
		Stack s = new Stack();
		for(int i=1; i<=10; i++)
			s.push(i);

		//Reverse a string using java's implementation with generics
		
		//It has to have a namespace, because I already defined a Stack class before
		java.util.Stack<Character> k = new java.util.Stack<Character>();
		String word = "String";
		char[] c = word.toCharArray();

		for(char x : c){
			k.push(x);
		}

		while(k.size() != 0){
			System.out.println(k.pop());	
		}

	}

}

