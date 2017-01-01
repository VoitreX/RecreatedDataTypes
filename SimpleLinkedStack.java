/**
*SimpleArrayStack 
*@author Hayden Hudgins
*@author section 5
*
*@version lab3
*@version Fall 2016
*/

public class SimpleLinkedStack<T> implements SimpleStack<T>{
	//private Node head;
	private Node tail;
	private int size = 0;


	public SimpleLinkedStack(){
		//head = new Node(null);
		tail = new Node(null);
		//tail = head;
	}


	public T peek(){
		if (size <= 0) { throw new java.util.NoSuchElementException(); }
		return tail.element;
	}
	public T pop(){
		if (size<=0) { throw new java.util.NoSuchElementException(); }
		tail = tail.previous;
		Node old = tail.next;
		tail.next=null;
		size--;
		return old.element;
	}
	public void push(T element){
		Node add = new Node(element);
		tail.next = add;
		add.previous = tail;
		tail = add;
		size++;
	}
	public int size() { return size; }

	//----------------------------------------------

	private class Node{

		private Node next;
		private Node previous;
		private T element;

		public Node(T element){
			this.element=element;
		}

	}
}