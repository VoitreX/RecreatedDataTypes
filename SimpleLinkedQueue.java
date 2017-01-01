/**
*SimpleLinkedQueue 
*@author Hayden Hudgins
*@author section 5
*
*@version Lab 1
*@version Fall 2016
*/

public class SimpleLinkedQueue<T> implements SimpleQueue<T> {
	private int length = 0;
	private Node front;
	private Node back;

	public SimpleLinkedQueue(){
		front = new Node(null);
		back = front;
	}

	public T dequeue()throws java.util.NoSuchElementException{
		if (size() == 0){throw new java.util.NoSuchElementException();}
		Node remove=front.next;
		front.next = remove.next;
		length--;
		return remove.element;
	}
	public void enqueue(T element){
		Node add = new Node(element);
		back.next = add;
		back = add;
		length++;
	}

	public T peek()throws java.util.NoSuchElementException{
		if (size() == 0){throw new java.util.NoSuchElementException();}
		return front.next.element;
	}

	public int size(){
			return length;
	}

	//-------------------------------------

	private class Node{

		private Node next;
		private T element;

		public Node(T element){
			this.element=element;
		}

	}
}