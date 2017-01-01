/**
*PriorityQueue Class
*@author Hayden Hudgins
*@author section 5
*
*@version Project 3
*@version Fall 2016
*/

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<? super T>> implements SimpleQueue<T>{
	private ArrayList<T> myArray = new ArrayList<T>();
	private boolean isMax = false;

	public PriorityQueue(){
		myArray.add(null);
	}

	public PriorityQueue(boolean isMax){
		myArray.add(null);
		this.isMax=isMax;
	}

	public PriorityQueue(T[] arr, int size){
		myArray.add(null);
		for (int i = 0; i < size; i++){
			this.enqueue(arr[i]);
		}
		
	}

	public PriorityQueue(T[] arr, int size, boolean isMax){
		myArray.add(null);
		this.isMax=isMax;
		for (int i = 0; i < size; i++){
			this.enqueue(arr[i]);
		}
		
	}

	public T dequeue(){
		if (myArray.size()==1){
			throw new java.util.NoSuchElementException();
		}
		T ret = myArray.get(1);
		T old = myArray.remove(myArray.size()-1);
		int spot = 1;
		if (isMax == false) { 
			if ( ret.compareTo(old) != 0){
				dequeueMin(spot, old);
			}
			return ret;
		}
		else { 
			if ( ret.compareTo(old) != 0){
				dequeueMax(spot, old);
			}
			return ret;
		}
	}

	private void dequeueMin(int spot, T old){
		if (spot != 1){
			myArray.set( (spot/2), myArray.get(spot) );
		}
	
		if ( (spot*2) >= myArray.size()  && ((spot*2)+1) >= myArray.size()  ) { 
			myArray.set(spot, old);
			return;
		}
		else if ( ((spot*2)+1) >= myArray.size() || ((myArray.get(spot*2)).compareTo(myArray.get((spot*2)+1) ) < 0) ) {
			if ( old.compareTo(myArray.get(spot*2) )< 0 ) {
				myArray.set(spot, old);
				return;
			}
			dequeueMin((spot*2), old);		
		}
		else if ( ((spot*2)+1) < myArray.size() ){
			if ( old.compareTo(myArray.get((spot*2)+1)) < 0) {
				myArray.set(spot, old);
				return;
			}	
			dequeueMin(((spot*2)+1), old);
		}
	}

	private void dequeueMax(int spot, T old){
		if (spot != 1){
			myArray.set( (spot/2), myArray.get(spot) );
		}
	
		if ( (spot*2) >= myArray.size()  && ((spot*2)+1) >= myArray.size()  ) { 
			myArray.set(spot, old);
			return;
		}
		else if ( ((spot*2)+1) >= myArray.size() || ((myArray.get(spot*2)).compareTo(myArray.get((spot*2)+1) ) > 0) ) {
			if ( old.compareTo(myArray.get(spot*2) )> 0 ) {
				myArray.set(spot, old);
				return;
			}
			dequeueMax((spot*2), old);		
		}
		else if ( ((spot*2)+1) < myArray.size() ){
			if ( old.compareTo(myArray.get((spot*2)+1)) > 0) {
				myArray.set(spot, old);
				return;
			}	
			dequeueMax(((spot*2)+1), old);
		}
	}

	//1mill items < 3 ms

	public void enqueue(T element){
		int spot = myArray.size();
		myArray.add(null);
		if (isMax == false){
			while (spot!=1 && (element.compareTo(myArray.get(spot/2))) < 0){
				myArray.set(spot, myArray.get(spot/2));
				spot = spot/2;
			}
		}
		if (isMax == true){
			while (spot!= 1 && element.compareTo(myArray.get(spot/2)) > 0 ){
				myArray.set(spot, myArray.get(spot/2));
				spot = spot/2;
			}
		}
		myArray.set(spot, element);
	}

	public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k){
		PriorityQueue<E> kthqueue;
		if (k < (size - k +1)){
			kthqueue = new PriorityQueue<E>(arr, k);
			int pos = k;
			while (pos < size){
				if ((arr[pos].compareTo(kthqueue.peek()))>0){
					kthqueue.dequeue();
					kthqueue.enqueue(arr[pos]);
				}
				pos++;
			}
		}
		else {
			kthqueue = new PriorityQueue<E>(arr, (size-k+1), true);
			int pos = size-k+1;
			while (pos < size){
				if ((arr[pos].compareTo(kthqueue.peek()))<0){
					kthqueue.dequeue();
					kthqueue.enqueue(arr[pos]);
				}
				pos++;
			}
		}

		return kthqueue.peek();
	}

	public T peek(){
		if (myArray.size() <= 1){
			throw new java.util.NoSuchElementException();
		}
		return myArray.get(1);
	}

	public int size(){
		return myArray.size()-1;
	}

	public static <E extends Comparable<? super E>> void sort(E[] arr, int size){
		PriorityQueue<E> sort = new PriorityQueue<E>(arr, size);
		for (int i = 0 ; i <size; i++){
			arr[i]=sort.dequeue();
		}
	}
	
}