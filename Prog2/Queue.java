/*  Brian Chenoweth
    masc0329
*/

package data_structures;
import java.util.Iterator;

public class Queue<E> implements Iterable<E> {
	private LinearListADT<E> storage;
	
	public Queue(){
		storage=new LinearList<E>();
		
	}

	 // inserts the object obj into the queue
    public void enqueue(E obj) {
    	storage.addLast(obj);
    }
    	
     
    // removes and returns the object at the front of the queue   
    public E dequeue()  {
    	return storage.removeFirst();
    }
    
    // returns the number of objects currently in the queue    
    public int size() {
    	return storage.size();
    }
    
    // returns true if the queue is empty, otherwise false   
    public boolean isEmpty() {
    	return storage.isEmpty();
    }
    
    // returns but does not remove the object at the front of the queue   
    public E peek() {
    	return storage.peekFirst();
    }
    
    // returns true if the Object obj is in the queue    
    public boolean contains(E obj) {
    	return storage.contains(obj);
    }
     
    // returns the queue to an empty state  
    public void makeEmpty() {
    	storage.clear();
    }
    
    // removes the Object obj if it is in the queue and
    // returns true, otherwise returns false.
    public boolean remove(E obj){
    	return (storage.remove (obj))!=null;
    }
    
    // returns an iterator of the elements in the queue.  The elements
    // must be in the same sequence as dequeue would return them.    
    public Iterator<E> iterator() {
    	return storage.iterator();
    }	
}
