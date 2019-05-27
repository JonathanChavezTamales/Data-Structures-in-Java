import java.util.Queue;

public class BinaryTree{
	Node root;

	private static class Node{
		int data;
		Node left, right;

		public Node(int data){
			this.data = data;
		}
	}

	public BinaryTree(){
		this.root = null;
	}

	//Se le puede pasar cualquier root desde el que se quiera traversear, no significa el root de todo el arbol
	public void traversePreorder(Node root){
		//Caso base
		if(root == null){
			return;
		}
		
		//Visit (puede ser imprimir, guardar en array, sumar, etc.)
		System.out.println(root.data);

		traversePreorder(root.left);
		traversePreorder(root.right);
	}

	public void inOrder(Node root){
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	public void postOrder(Node root){
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public void levelOrder(Node root){
		//This is not a base case, because it is not recursive, instead it is a condition when the tree is empty.
		if(root == null)
			return;
		java.util.Queue<Node> q = new java.util.LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			Node newRoot = q.poll();
			System.out.println(newRoot.data);
			if(newRoot.left != null)
				q.offer(newRoot.left);
			if(newRoot.right != null)
				q.offer(newRoot.right);
		}
	
	}	

	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(4);
		bt.root.right = new Node(8);
		bt.root.right.left = new Node(6);	
		bt.levelOrder(bt.root);
	}

}
