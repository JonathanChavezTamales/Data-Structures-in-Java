import java.util.NoSuchElementException;

public class DoublyLinkedList{
    Node head;
    Node tail;
    int length;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public static class Node{
        Node prev, next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    public void displayForwards(){
		//Traversing
		Node a = head;

		while(a != null){
			System.out.print("<-- | "+a.data+" | -->");
			a = a.next;
		}

		System.out.println("null");
    }

    public void displayBackwards(){
        Node current = tail;
        while(current!=null){
            System.out.print("<-- | "+current.data+" | -->");
            current = current.prev;
        }
        System.out.print("null");
    }
    
    
    public boolean isEmpty(){
        return length==0;
    }

    public void insertAtBeginning(Node current){
        if(isEmpty())
            this.tail = current;
        else{
            head.prev = current;
        }
        current.next = head;
        head = current;
        this.length++;
    }

    public void insertAtEnd(Node newNode){
        if(isEmpty())
            head = newNode;
        else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public void deleteFirstNode(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else if(head == tail){
            tail = null;
            head = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        length--;
    }

    public void deleteLastNode(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else if(head == tail){
            tail = null;
            head = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        }
        length--;
    }



    //MAIN
    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.head = new Node(4);
        dll.insertAtBeginning(new Node(7));
        dll.insertAtBeginning(new Node(8));
        dll.insertAtBeginning(new Node(2));
        dll.insertAtEnd(new Node(1000));
        dll.deleteFirstNode();
        dll.deleteLastNode();


        dll.displayForwards();
        dll.displayBackwards();
        
    }
}
