/**
*SimpleQueue Interface
*@author Hayden Hudgins
*@author section 5
*
*@version project 1
*@version Fall 2016
*/

public interface SimpleQueue<T>
{
	public T dequeue();
	public void enqueue(T element);
	public T peek();
	public int size();

}