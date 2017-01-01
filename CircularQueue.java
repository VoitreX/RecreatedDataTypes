/**
*CircularQueue 
*@author Hayden Hudgins
*@author section 5
*
*@version project 1
*@version Fall 2016
*/

public class CircularQueue<T> implements SimpleQueue<T> {
	private int size = 0;
	private int back = -1;
	private int front = 0;
	public static final int INITIAL_LENGTH = 10;
	private T[] arr;

	@SuppressWarnings("unchecked")
	public CircularQueue() throws MyException {
		if (INITIAL_LENGTH <= 0) {throw new MyException();}	

		arr = (T[])new Object[INITIAL_LENGTH];
	}
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int initialCapacity) throws MyException {
		if (initialCapacity <= 0) {throw new MyException();}		
		arr = (T[])new Object[initialCapacity];
	}
	public T dequeue() throws java.util.NoSuchElementException {
		if (size <= 0){ throw new java.util.NoSuchElementException(); }
		T old = arr[front];
		if(front == arr.length-1){
			front = 0;
		}
		else {front++;}
		size--;
		return old;
	}
	@SuppressWarnings("unchecked")
	public void enqueue(T element){
		if (size == arr.length){
			T[] newArr = (T[]) new Object[(arr.length * 2)];
			int j = front;
			for (int i = 0; i < size; i++){
				newArr[i]= arr[j];
				if (j == arr.length-1){
					j = 0;
				}
				else{j++;}
			}
			arr = newArr;
			front = 0;
			back = size-1;
		}		
		if (back == (arr.length-1)) { back = -1; }
		back++;
		arr[back] = element;
		size++;
	}
	public T peek() throws java.util.NoSuchElementException {
		if (size ==0){ throw new java.util.NoSuchElementException(); }
		return arr[front];
	}
	public int size() {return size;}
	public Object[] unusualMethodForTestingPurposesOnly() {return arr;}

	public static class MyException extends RuntimeException {
		MyException() { super(); }
		MyException(String s){ super(s); }
	}
}